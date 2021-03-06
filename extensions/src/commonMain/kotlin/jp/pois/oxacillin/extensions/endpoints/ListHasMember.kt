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

package jp.pois.oxacillin.extensions.endpoints

import jp.pois.oxacillin.core.exceptions.PenicillinTwitterApiException
import jp.pois.oxacillin.core.exceptions.TwitterApiError
import jp.pois.oxacillin.core.request.action.ApiAction
import jp.pois.oxacillin.endpoints.Lists
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.lists.member
import jp.pois.oxacillin.extensions.utils.emptyModelDeserializer

/**
 * Returns true if the specified user is a member of the specified list.
 *
 * @param listId The numerical id of the list.
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [ApiAction] for [Boolean].
 */
public fun Lists.hasMember(
    listId: Long,
    userId: Long,
    vararg options: Option
): ApiAction<Boolean> = hasMemberInner {
    member(emptyModelDeserializer, listId, userId, false, true, *options)
}

/**
 * Returns true if the specified user is a member of the specified list.
 *
 * @param listId The numerical id of the list.
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [ApiAction] for [Boolean].
 */
public fun Lists.hasMember(
    listId: Long,
    screenName: String,
    vararg options: Option
): ApiAction<Boolean> = hasMemberInner {
    member(emptyModelDeserializer, listId, screenName, false, true, *options)
}

/**
 * Returns true if the specified user is a member of the specified list.
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [ApiAction] for [Boolean].
 */
public fun Lists.hasMember(
    slug: String,
    ownerScreenName: String,
    userId: Long,
    vararg options: Option
): ApiAction<Boolean> = hasMemberInner {
    member(emptyModelDeserializer, slug, ownerScreenName, userId, false, true, *options)
}

/**
 * Returns true if the specified user is a member of the specified list.
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [ApiAction] for [Boolean].
 */
public fun Lists.hasMember(
    slug: String,
    ownerScreenName: String,
    screenName: String,
    vararg options: Option
): ApiAction<Boolean> = hasMemberInner {
    member(emptyModelDeserializer, slug, ownerScreenName, screenName, false, true, *options)
}

/**
 * Returns true if the specified user is a member of the specified list.
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerId The user ID of the user who owns the list being requested by a slug.
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [ApiAction] for [Boolean].
 */
public fun Lists.hasMember(
    slug: String,
    ownerId: Long,
    userId: Long,
    vararg options: Option
): ApiAction<Boolean> = hasMemberInner {
    member(emptyModelDeserializer, slug, ownerId, userId, false, true, *options)
}

/**
 * Returns true if the specified user is a member of the specified list.
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerId The user ID of the user who owns the list being requested by a slug.
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [ApiAction] for [Boolean].
 */
public fun Lists.hasMember(
    slug: String,
    ownerId: Long,
    screenName: String,
    vararg options: Option
): ApiAction<Boolean> = hasMemberInner {
    member(emptyModelDeserializer, slug, ownerId, screenName, false, true, *options)
}

// TODO https://youtrack.jetbrains.com/issue/KT-45131
internal fun Lists.hasMemberInner(block: Lists.() -> Unit): ApiAction<Boolean> = delegatedAction {
    runCatching {
        block()
        true
    }.recover {
        if (it is PenicillinTwitterApiException && it.error == TwitterApiError.UserNotInThisList) {
            false
        } else {
            throw it
        }
    }.getOrThrow()
}
