/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2019 Nephy Project Team
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

@file:Suppress("UNUSED")

package jp.nephy.penicillin.extensions.models.builder

import jp.nephy.jsonkt.asJsonElement
import jp.nephy.jsonkt.edit
import jp.nephy.jsonkt.jsonArrayOf
import jp.nephy.jsonkt.jsonObjectOf
import jp.nephy.penicillin.models.Status
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import java.text.SimpleDateFormat
import java.util.*

class CustomStatusBuilder: JsonBuilder<Status> {
    override var json = jsonObjectOf(
            "created_at" to null,
            "id" to null,
            "id_str" to null,
            "text" to "",
            "source" to null,
            "truncated" to false,
            "in_reply_to_status_id" to null,
            "in_reply_to_status_id_str" to null,
            "in_reply_to_user_id" to null,
            "in_reply_to_user_id_str" to null,
            "in_reply_to_screen_name" to null,
            "user" to null,
            "geo" to null,
            "coordinates" to null,
            "place" to null,
            "contributors" to null,
            "is_quote_status" to false,
            "quote_count" to 0,
            "reply_count" to 0,
            "retweet_count" to 0,
            "favorite_count" to 0,
            "entities" to jsonObjectOf(
                "hashtags" to jsonArrayOf(),
                "symbols" to jsonArrayOf(),
                "user_mentions" to jsonArrayOf(),
                "urls" to jsonArrayOf()
            ),
            "favorited" to false,
            "retweeted" to false,
            "filter_level" to "low",
            "lang" to "ja",
            "timestamp_ms" to null
    )

    private lateinit var text: String
    fun text(value: String) {
        text = value
    }
    fun text(operation: () -> Any?) {
        text = operation.invoke().toString()
    }
    fun textBuilder(builder: StringBuilder.() -> Unit) {
        text = buildString(builder)
    }

    private var sourceName = "Tweetstorm"
    private var sourceUrl = "https://github.com/SlashNephy/Tweetstorm"
    fun source(name: String, url: String) {
        sourceName = name
        sourceUrl = url
    }

    private var createdAt: Date? = null
    fun createdAt(date: Date? = null) {
        createdAt = date
    }

    private var user = CustomUserBuilder()
    fun user(builder: CustomUserBuilder.() -> Unit) {
        user.apply(builder)
    }

    private var inReplyToStatusId: Long? = null
    private var inReplyToUserId: Long? = null
    private var inReplyToScreenName: String? = null
    fun inReplyTo(statusId: Long, userId: Long, screenName: String) {
        inReplyToStatusId = statusId
        inReplyToUserId = userId
        inReplyToScreenName = screenName
    }

    private var retweeted = false
    fun alreadyRetweeted() {
        retweeted = true
    }

    private var favorited = false
    fun alreadyFavorited() {
        favorited = true
    }

    private var retweetCount = 0
    private var favoriteCount = 0
    fun count(retweet: Int = 0, favorite: Int = 0) {
        retweetCount = retweet
        favoriteCount = favorite
    }

    data class UrlEntity(val url: String, val start: Int, val end: Int)

    private val urls = mutableListOf<UrlEntity>()
    fun url(url: String, start: Int, end: Int) {
        urls += UrlEntity(url, start, end)
    }

    override fun build(): Status {
        val id = runBlocking {
            generateId()
        }
        val user = user.build()

        return Status(json.edit {
            it["text"] = text

            it["id"] = id
            it["id_str"] = id.toString()

            it["source"] = "<a href=\"$sourceUrl\" rel=\"nofollow\">$sourceName</a>"

            it["user"] = user

            it["created_at"] = createdAt.toCreatedAt()
            it["timestamp_ms"] = (createdAt ?: Date()).time.toString()

            it["retweeted"] = retweeted
            it["favorited"] = favorited
            it["retweet_count"] = retweetCount
            it["favorite_count"] = favoriteCount

            it["in_reply_to_status_id"] = inReplyToStatusId
            it["in_reply_to_status_id_str"] = inReplyToStatusId.toString()
            it["in_reply_to_user_id"] = inReplyToUserId
            it["in_reply_to_user_id_str"] = inReplyToUserId.toString()
            it["in_reply_to_screen_name"] = inReplyToScreenName

            val entities = it["entities"].asJsonElement().jsonObject

            it["entities"] = entities.edit { entity ->
                entity["urls"] = urls.map { urlEntity ->
                    jsonObjectOf(
                        "display_url" to urlEntity.url.removePrefix("https://").removePrefix("http://"),
                        "url" to urlEntity.url,
                        "indices" to jsonArrayOf(urlEntity.start, urlEntity.end),
                        "expanded_url" to urlEntity.url
                    )
                }
            }
        })
    }
}

internal fun Date?.toCreatedAt(): String {
    val dateFormatter = SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH).also {
        it.timeZone = TimeZone.getTimeZone("UTC")
    }
    return dateFormatter.format(this ?: Date())
}

private var id = 100000001L
private val idMutex = Mutex()
internal suspend fun generateId(): Long {
    return idMutex.withLock {
        id.also {
            id += 2
        }
    }
}