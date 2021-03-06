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

package jp.pois.oxacillin.endpoints.lists

import jp.pois.oxacillin.core.request.action.CursorJsonApiAction
import jp.pois.oxacillin.core.request.cursorJson
import jp.pois.oxacillin.core.request.parameters
import jp.pois.oxacillin.core.session.get
import jp.pois.oxacillin.endpoints.Lists
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.models.CursorModel
import jp.pois.oxacillin.utils.deserializer
import kotlinx.serialization.DeserializationStrategy

/**
 * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-ownerships)
 *
 * @param count The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
 * @param cursor Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See [Cursoring](https://developer.twitter.com/en/docs/basics/cursoring) for more information.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [CursorJsonApiAction] for [CursorLists] model.
 */
public fun <M: CursorModel<T>, T: Any> Lists.ownerships(
    deserializer: DeserializationStrategy<M>,
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = ownershipsInternal(deserializer, null, null, count, cursor, *options)

public inline fun <reified M: CursorModel<T>, T: Any> Lists.ownerships(
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = ownerships(deserializer(), count, cursor, *options)

/**
 * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-ownerships)
 *
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param count The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
 * @param cursor Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See [Cursoring](https://developer.twitter.com/en/docs/basics/cursoring) for more information.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [CursorJsonApiAction] for [CursorLists] model.
 */
public fun <M: CursorModel<T>, T: Any> Lists.ownershipsByUserId(
    deserializer: DeserializationStrategy<M>,
    userId: Long,
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = ownershipsInternal(deserializer, userId, null, count, cursor, *options)

public inline fun <reified M: CursorModel<T>, T: Any> Lists.ownershipsByUserId(
    userId: Long,
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = ownershipsByUserId(deserializer(), userId, count, cursor, *options)

/**
 * Returns the lists owned by the specified Twitter user. Private lists will only be shown if the authenticated user is also the owner of the lists.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-ownerships)
 *
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param count The amount of results to return per page. Defaults to 20. No more than 1000 results will ever be returned in a single page.
 * @param cursor Breaks the results into pages. Provide a value of -1 to begin paging. Provide values as returned in the response body's next_cursor and previous_cursor attributes to page back and forth in the list. It is recommended to always use cursors when the method supports them. See [Cursoring](https://developer.twitter.com/en/docs/basics/cursoring) for more information.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [CursorJsonApiAction] for [CursorLists] model.
 */
public fun <M: CursorModel<T>, T: Any> Lists.ownerships(
    deserializer: DeserializationStrategy<M>,
    screenName: String,
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = ownershipsInternal(deserializer, null, screenName, count, cursor, *options)

public inline fun <reified M: CursorModel<T>, T: Any> Lists.ownerships(
    screenName: String,
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<M, T> = ownerships(deserializer(), screenName, count, cursor, *options)

private fun <M: CursorModel<T>, T: Any> Lists.ownershipsInternal(
    deserializer: DeserializationStrategy<M>,
    userId: Long? = null,
    screenName: String? = null,
    count: Int? = null,
    cursor: Long? = null,
    vararg options: Option
) = client.session.get("/1.1/lists/ownerships.json") {
    parameters(
        "user_id" to userId,
        "screen_name" to screenName,
        "count" to count,
        "cursor" to cursor,
        *options
    )
}.cursorJson(deserializer)
