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

package jp.pois.oxacillin.defaults.endpoints.welcomemessages

import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.defaults.endpoints.WelcomeMessages
import jp.pois.oxacillin.defaults.models.WelcomeMessage
import jp.pois.oxacillin.endpoints.welcomeMessages
import jp.pois.oxacillin.endpoints.welcomemessages.list

/**
 * Returns a list of Welcome Messages.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/direct-messages/welcome-messages/api-reference/list-welcome-messages)
 * 
 * @param count Number of welcome messages to be returned. Max of 50. Default is 20.
 * @param cursor For paging through result sets greater than 1 page, use the “next_cursor” property from the previous request.
 * @param options Optional. Custom parameters of this request.
 * @receiver [WelcomeMessages] endpoint instance.
 * @return [JsonGeneralApiAction] for [WelcomeMessage.List] model.
 */
public inline fun WelcomeMessages.list(
    count: Int? = null,
    cursor: String? = null,
    vararg options: Option
): JsonGeneralApiAction<WelcomeMessage.List> = client.welcomeMessages.list(count, cursor, *options)
