/*
 * The MIT License (MIT)
 *
 *     Copyright (c) 2017-2019 Nephy Project Team
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

package jp.nephy.penicillin.extensions.endpoints

import jp.nephy.jsonkt.toJsonObject
import jp.nephy.jsonkt.toJsonString
import jp.nephy.penicillin.core.emulation.EmulationMode
import jp.nephy.penicillin.core.request.action.DelegatedAction
import jp.nephy.penicillin.endpoints.Option
import jp.nephy.penicillin.endpoints.PrivateEndpoint
import jp.nephy.penicillin.endpoints.Statuses
import jp.nephy.penicillin.endpoints.cards
import jp.nephy.penicillin.endpoints.cards.create
import jp.nephy.penicillin.endpoints.statuses.create
import jp.nephy.penicillin.extensions.await

@PrivateEndpoint(EmulationMode.TwitterForiPhone)
fun Statuses.createPollTweet(
    status: String,
    choices: List<String>,
    minutes: Int = 1440,
    vararg options: Option
) = DelegatedAction(client) {
    val card = client.cards.create(
        cardData = linkedMapOf<String, Any>().apply {
            choices.forEachIndexed { i, choice ->
                put("twitter:string:choice${i + 1}_label", choice)
            }
            put("twitter:api:api:endpoint", "1")
            put("twitter:card", "poll${choices.size}choice_text_only")
            put("twitter:long:duration_minutes", minutes)
        }.toJsonObject().toJsonString()
    ).await()
    
    create(status, cardUri = card.result.cardUri, options = *options).await().result
}