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

import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.defaults.endpoints.Blocks
import jp.pois.oxacillin.defaults.models.User
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.blocks
import jp.pois.oxacillin.endpoints.blocks.destroyByScreenName
import jp.pois.oxacillin.endpoints.blocks.destroyByUserId

/**
 * Un-blocks the user specified in the ID parameter for the authenticating user. Returns the un-blocked user when successful. If relationships existed before the block was instantiated, they will not be restored.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/post-blocks-destroy)
 *
 * @param screenName Required. The screen name of the potentially blocked user. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param includeEntities Optional. The entities node will not be included when set to false.
 * @param skipStatus Optional. When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Blocks] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 * @see Blocks.destroyByUserId
 */
public inline fun Blocks.destroyByScreenName(
    screenName: String,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.blocks.destroyByScreenName(screenName, includeEntities, skipStatus, *options)

    /**
 * Un-blocks the user specified in the ID parameter for the authenticating user. Returns the un-blocked user when successful. If relationships existed before the block was instantiated, they will not be restored.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/mute-block-report-users/api-reference/post-blocks-destroy)
 *
 * @param userId Required. The ID of the potentially blocked user. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param includeEntities Optional. The entities node will not be included when set to false.
 * @param skipStatus Optional. When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Blocks] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 * @see Blocks.destroyByScreenName
 */
public inline fun Blocks.destroyByUserId(
    userId: Long,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.blocks.destroyByUserId(userId, includeEntities, skipStatus, *options)
