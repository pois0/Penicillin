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

package jp.pois.oxacillin.defaults.endpoints.lists

import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.defaults.endpoints.Lists
import jp.pois.oxacillin.defaults.models.User
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.lists
import jp.pois.oxacillin.endpoints.lists.subscriber

/**
 * Check if the specified user is a subscriber of the specified list. Returns the user if they are a subscriber.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-subscribers-show)
 * 
 * @param listId The numerical id of the list.
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param includeEntities When set to either true, t or 1, each Tweet will include a node called "entities". This node offers a variety of metadata about the tweet in a discreet structure, including: user_mentions, urls, and hashtags. While entities are opt-in on timelines at present, they will be made a default component of output in the future. See [Tweet Entities](https://developer.twitter.com/overview/api/tweets) for more details.
 * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 */
public inline fun Lists.subscriber(
    listId: Long,
    userId: Long,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.lists.subscriber(listId, userId, includeEntities, skipStatus, *options)

/**
 * Check if the specified user is a subscriber of the specified list. Returns the user if they are a subscriber.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-subscribers-show)
 *
 * @param listId The numerical id of the list.
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param includeEntities When set to either true, t or 1, each Tweet will include a node called "entities". This node offers a variety of metadata about the tweet in a discreet structure, including: user_mentions, urls, and hashtags. While entities are opt-in on timelines at present, they will be made a default component of output in the future. See [Tweet Entities](https://developer.twitter.com/overview/api/tweets) for more details.
 * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 */
public inline fun Lists.subscriber(
    listId: Long,
    screenName: String,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.lists.subscriber(listId, screenName, includeEntities, skipStatus, *options)

/**
 * Check if the specified user is a subscriber of the specified list. Returns the user if they are a subscriber.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-subscribers-show)
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param includeEntities When set to either true, t or 1, each Tweet will include a node called "entities". This node offers a variety of metadata about the tweet in a discreet structure, including: user_mentions, urls, and hashtags. While entities are opt-in on timelines at present, they will be made a default component of output in the future. See [Tweet Entities](https://developer.twitter.com/overview/api/tweets) for more details.
 * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 */
public inline fun Lists.subscriber(
    slug: String,
    ownerScreenName: String,
    userId: Long,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.lists.subscriber(slug, ownerScreenName, userId, includeEntities, skipStatus, *options)

/**
 * Check if the specified user is a subscriber of the specified list. Returns the user if they are a subscriber.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-subscribers-show)
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerScreenName The screen name of the user who owns the list being requested by a slug.
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param includeEntities When set to either true, t or 1, each Tweet will include a node called "entities". This node offers a variety of metadata about the tweet in a discreet structure, including: user_mentions, urls, and hashtags. While entities are opt-in on timelines at present, they will be made a default component of output in the future. See [Tweet Entities](https://developer.twitter.com/overview/api/tweets) for more details.
 * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 */
public inline fun Lists.subscriber(
    slug: String,
    ownerScreenName: String,
    screenName: String,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.lists.subscriber(slug, ownerScreenName, screenName, includeEntities, skipStatus, *options)

/**
 * Check if the specified user is a subscriber of the specified list. Returns the user if they are a subscriber.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-subscribers-show)
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerId The user ID of the user who owns the list being requested by a slug.
 * @param userId The ID of the user for whom to return results. Helpful for disambiguating when a valid user ID is also a valid screen name.
 * @param includeEntities When set to either true, t or 1, each Tweet will include a node called "entities". This node offers a variety of metadata about the tweet in a discreet structure, including: user_mentions, urls, and hashtags. While entities are opt-in on timelines at present, they will be made a default component of output in the future. See [Tweet Entities](https://developer.twitter.com/overview/api/tweets) for more details.
 * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 */
public inline fun Lists.subscriber(
    slug: String,
    ownerId: Long,
    userId: Long,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.lists.subscriber(slug, ownerId, userId, includeEntities, skipStatus, *options)

/**
 * Check if the specified user is a subscriber of the specified list. Returns the user if they are a subscriber.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/create-manage-lists/api-reference/get-lists-subscribers-show)
 *
 * @param slug You can identify a list by its slug instead of its numerical id. If you decide to do so, note that you'll also have to specify the list owner using the owner_id or owner_screen_name parameters.
 * @param ownerId The user ID of the user who owns the list being requested by a slug.
 * @param screenName The screen name of the user for whom to return results. Helpful for disambiguating when a valid screen name is also a user ID.
 * @param includeEntities When set to either true, t or 1, each Tweet will include a node called "entities". This node offers a variety of metadata about the tweet in a discreet structure, including: user_mentions, urls, and hashtags. While entities are opt-in on timelines at present, they will be made a default component of output in the future. See [Tweet Entities](https://developer.twitter.com/overview/api/tweets) for more details.
 * @param skipStatus When set to either true, t or 1 statuses will not be included in the returned user objects.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Lists] endpoint instance.
 * @return [JsonGeneralApiAction] for [User] model.
 */
public inline fun Lists.subscriber(
    slug: String,
    ownerId: Long,
    screenName: String,
    includeEntities: Boolean? = null,
    skipStatus: Boolean? = null,
    vararg options: Option
): JsonGeneralApiAction<User> = client.lists.subscriber(slug, ownerId, screenName, includeEntities, skipStatus, *options)
