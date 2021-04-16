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

@file:Suppress("UNUSED", "NOTHING_TO_INLINE")

package jp.pois.oxacillin.defaults.endpoints.accountactivity

import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.defaults.endpoints.AccountActivity
import jp.pois.oxacillin.defaults.models.Subscription
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.defaults.endpoints.accountActivity
import jp.pois.oxacillin.defaults.endpoints.accountactivity.listSubscriptions
import jp.pois.oxacillin.endpoints.accountActivity
import jp.pois.oxacillin.endpoints.accountactivity.listSubscriptions

/**
 * Returns a list of the current All Activity type subscriptions. Note that the /list endpoint requires application-only OAuth, so requests should be made using a bearer token instead of user context.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/accounts-and-users/subscribe-account-activity/api-reference/aaa-premium#get-account-activity-all-webhooks)
 *
 * @param envName Environment name.
 * @param options Optional. Custom parameters of this request.
 * @receiver [AccountActivity] endpoint instance.
 * @return [JsonGeneralApiAction] for [Subscription.List] model.
 */
public inline fun AccountActivity.listSubscriptions(
    envName: String,
    vararg options: Option
): JsonGeneralApiAction<Subscription.List> = client.accountActivity.listSubscriptions(envName, *options)
