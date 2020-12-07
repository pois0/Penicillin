/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2020 StarryBlueSky
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

@file:Suppress("UNUSED", "PublicApiImplicitType", "KDocMissingDocumentation")

package blue.starry.penicillin.models

import blue.starry.jsonkt.JsonObject
import blue.starry.jsonkt.delegation.*
import blue.starry.penicillin.core.session.ApiClient


data class TrendType(override val json: JsonObject, override val client: ApiClient): PenicillinModel {
    val trend by nullableModel { Trend(it, client) }
    val promotedTrend by nullableModel { PromotedTrend(it, client) }

    data class Trend(override val json: JsonObject, override val client: ApiClient): PenicillinModel {
        val name by string
        val description by nullableString("meta_description")
        val rank by int
        val token by string
        val context by nullableModel { Context(it, client) }
        val target by nullableModel { Target(it, client) }

        data class Context(override val json: JsonObject, override val client: ApiClient): PenicillinModel {
            val relatedQuery by stringList("query")
        }

        data class Target(override val json: JsonObject, override val client: ApiClient): PenicillinModel {
            val query by string
            val pinnedTweets by longList("pinned_tweets")
            val pinnedTweetsStr by stringList("pinned_tweets_string")
        }
    }

    data class PromotedTrend(override val json: JsonObject, override val client: ApiClient): PenicillinModel
}