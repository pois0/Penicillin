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

package jp.pois.oxacillin.endpoints.followrequests


import jp.pois.oxacillin.core.request.action.CursorJsonApiAction
import jp.pois.oxacillin.core.request.cursorJson
import jp.pois.oxacillin.core.request.parameters
import jp.pois.oxacillin.core.session.get
import jp.pois.oxacillin.endpoints.FollowRequests
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.models.CursorModel
import jp.pois.oxacillin.utils.deserializer
import kotlinx.serialization.DeserializationStrategy

/**
 * Returns a collection of numeric IDs for every protected user for whom the authenticating user has a pending follow request.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/follow-search-get-users/api-reference/get-friendships-outgoing)
 *
 * @param cursor Causes the list of connections to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. If no cursor is provided, a value of -1 will be assumed, which is the first "page." The response from the API will include a previous_cursor and next_cursor to allow paging back and forth. See [Using cursors to navigate collections](https://developer.twitter.com/en/docs/basics/cursoring) for more information.
 * @param stringifyIds Some programming environments will not consume Twitter IDs due to their size. Provide this option to have IDs returned as strings instead. More about [Twitter IDs](https://developer.twitter.com/en/docs/basics/twitter-ids).
 * @param options Optional. Custom parameters of this request.
 * @receiver [FollowRequests] endpoint instance.
 * @return [CursorJsonApiAction] for [CursorIds] model.
 */
public fun <M: CursorModel<T>, T: Any>FollowRequests.outgoing(
    deserializer: DeserializationStrategy<M>,
    cursor: Long? = null,
    stringifyIds: Boolean? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = client.session.get("/1.1/friendships/outgoing.json") {
    parameters(
        "cursor" to cursor,
        "stringify_ids" to stringifyIds,
        *options
    )
}.cursorJson(deserializer)

public inline fun <reified M: CursorModel<T>, T: Any>FollowRequests.outgoing(
    cursor: Long? = null,
    stringifyIds: Boolean? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = outgoing(deserializer(), cursor, stringifyIds, *options)
