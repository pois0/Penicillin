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

package jp.pois.oxacillin.endpoints.directmessages

import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.core.request.formBody
import jp.pois.oxacillin.core.request.json
import jp.pois.oxacillin.core.session.post
import jp.pois.oxacillin.endpoints.DirectMessages
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.directMessageDeprecatedMessage
import jp.pois.oxacillin.utils.deserializer
import kotlinx.serialization.DeserializationStrategy

/**
 * Abolished endpoint.
 *
 * @param options Optional. Custom parameters of this request.
 * @receiver [DirectMessages] endpoint instance.
 * @return [JsonGeneralApiAction] for [DirectMessage] model.
 */
@Deprecated(directMessageDeprecatedMessage, replaceWith = ReplaceWith("directMessageEvent.create", "jp.pois.oxacillin.endpoints.directMessageEvent", "jp.pois.oxacillin.endpoints.directmessages.events.create"))
public fun <T> DirectMessages.create(
    deserializer: DeserializationStrategy<T>,
    text: String,
    userId: Long? = null,
    screenName: String? = null,
    vararg options: Option
): JsonGeneralApiAction<T> = client.session.post("/1.1/direct_messages/new.json") {
    formBody(
        "text" to text,
        "user_id" to userId,
        "screen_name" to screenName,
        *options
    )
}.json(deserializer)

@Suppress("DEPRECATION")
@Deprecated(directMessageDeprecatedMessage, replaceWith = ReplaceWith("directMessageEvent.create", "jp.pois.oxacillin.endpoints.directMessageEvent", "jp.pois.oxacillin.endpoints.directmessages.events.create"))
public inline fun <reified T> DirectMessages.create(
    text: String,
    userId: Long? = null,
    screenName: String? = null,
    vararg options: Option
): JsonGeneralApiAction<T> = create(deserializer(), text, userId, screenName, *options)
