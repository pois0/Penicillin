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

@file:Suppress("UNUSED", "NOTHING_TO_INLINE")

package jp.pois.oxacillin.defaults.endpoints.blocks

import jp.pois.oxacillin.core.request.action.CursorJsonApiAction
import jp.pois.oxacillin.defaults.endpoints.Blocks
import jp.pois.oxacillin.defaults.models.User
import jp.pois.oxacillin.defaults.models.cursors.CursorUsers
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.blocks
import jp.pois.oxacillin.endpoints.blocks.listUsers

/**
 * Returns a collection of [user objects](https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/user-object) that the authenticating user is blocking.
 * 
 * **Important** This method is cursored, meaning your app must make multiple requests in order to receive all blocks correctly. See [Using cursors to navigate collections](https://developer.twitter.com/en/docs/basics/cursoring) for more details on how cursoring works.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/get-blocks-list)
 * 
 * @param includeEntities Optional. The entities node will not be included when set to false.
 * @param skipStatus Optional. When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param cursor Semi-Optional. Causes the list of blocked users to be broken into pages of no more than 5000 IDs at a time. The number of IDs returned is not guaranteed to be 5000 as suspended users are filtered out after connections are queried. If no cursor is provided, a value of -1 will be assumed, which is the first "page." The response from the API will include a previous_cursor and next_cursor to allow paging back and forth. See [Using cursors to navigate collections](https://developer.twitter.com/en/docs/basics/cursoring) for more information.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Blocks] endpoint instance.
 * @return [CursorJsonApiAction] for [CursorUsers] model.
 */
public inline fun Blocks.listUsers(
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    cursor: Long? = null,
    vararg options: Option
): CursorJsonApiAction<CursorUsers, User> = client.blocks.listUsers(includeEntities, skipStatus, cursor, *options)
