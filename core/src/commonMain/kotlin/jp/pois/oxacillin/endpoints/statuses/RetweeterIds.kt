/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2020 StarryBlueSky
 *     Copyright (c) 2021 poispois
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

package jp.pois.oxacillin.endpoints.statuses

import jp.pois.oxacillin.core.request.action.CursorJsonApiAction
import jp.pois.oxacillin.core.request.cursorJson
import jp.pois.oxacillin.core.request.parameters
import jp.pois.oxacillin.core.session.get
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.Statuses
import jp.pois.oxacillin.models.CursorModel
import jp.pois.oxacillin.utils.deserializer
import kotlinx.serialization.DeserializationStrategy

/**
 * Returns a collection of up to 100 user IDs belonging to users who have retweeted the Tweet specified by the id parameter.
 * This method offers similar data to [GET statuses/retweets/:id](https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/get-statuses-retweets-id).
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/tweets/post-and-engage/api-reference/get-statuses-retweeters-ids)
 * 
 * @param id The numerical ID of the desired status.
 * @param count Specifies the number of records to retrieve. Must be less than or equal to 100.
 * @param cursor Causes the list of IDs to be broken into pages of no more than 100 IDs at a time. The number of IDs returned is not guaranteed to be 100 as suspended users are filtered out after connections are queried. If no cursor is provided, a value of -1 will be assumed, which is the first "page." The response from the API will include a previous_cursor and next_cursor to allow paging back and forth. See [our cursor docs](https://developer.twitter.com/en/docs/basics/cursoring) for more information. While this method supports the cursor parameter, the entire result set can be returned in a single cursored collection. Using the count parameter with this method will not provide segmented cursors for use with this parameter.
 * @param stringifyIds    Many programming environments will not consume Tweet ids due to their size. Provide this option to have ids returned as strings instead.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Statuses] endpoint instance.
 * @return [CursorJsonApiAction] for [CursorIds] model.
 */
public fun <M: CursorModel<T>, T: Any> Statuses.retweeterIds(
    deserializer: DeserializationStrategy<M>,
    id: Long,
    count: Int? = null,
    cursor: Long? = null,
    stringifyIds: Boolean? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = client.session.get("/1.1/statuses/retweeters/ids.json") {
    parameters(
        "id" to id,
        "count" to count,
        "cursor" to cursor,
        "stringify_ids" to stringifyIds,
        *options
    )
}.cursorJson(deserializer)

public inline fun <reified M: CursorModel<T>, T: Any> Statuses.retweeterIds(
    id: Long,
    count: Int? = null,
    cursor: Long? = null,
    stringifyIds: Boolean? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = retweeterIds(deserializer(), id, count, cursor, stringifyIds, *options)
