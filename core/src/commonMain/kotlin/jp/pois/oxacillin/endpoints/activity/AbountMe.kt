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

package jp.pois.oxacillin.endpoints.activity

import jp.pois.oxacillin.core.emulation.EmulationMode
import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.core.request.json
import jp.pois.oxacillin.core.request.parameters
import jp.pois.oxacillin.core.session.get
import jp.pois.oxacillin.endpoints.Activity
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.utils.deserializer
import kotlinx.serialization.DeserializationStrategy

/**
 * Unknown endpoint.
 *
 * @param options Optional. Custom parameters of this request.
 * @receiver [Activity] endpoint instance.
 * @return [JsonGeneralApiAction] for [T] model.
 */
public fun <T> Activity.aboutMe(
    deserializer: DeserializationStrategy<T>,
    count: Int? = null,
    vararg options: Option
): JsonGeneralApiAction<T> = client.session.get("/1.1/activity/about_me.json") {
    emulationModes += EmulationMode.TwitterForiPhone

    parameters(
        "cards_platform" to "iPhone-13",
        "contributor_details" to "1",
        "count" to (count ?: "21"),
        "ext" to "altText,info360,mediaColor,mediaRestrictions,mediaStats,self_thread,stickerInfo",
        "filters" to "",
        "include_alert" to "0",
        "include_cards" to "1",
        "include_carousels" to "1",
        "include_entities" to "1",
        "include_ext_media_color" to "true",
        "include_media_features" to "true",
        "include_my_retweet" to "1",
        "include_profile_interstitial_type" to "true",
        "include_profile_location" to "true",
        "include_reply_count" to "1",
        "include_user_entities" to "true",
        "include_user_hashtag_entities" to "true",
        "include_user_mention_entities" to "true",
        "include_user_symbol_entities" to "true",
        "model_version" to "8",
        "tweet_mode" to "extended",
        *options,
        mode = EmulationMode.TwitterForiPhone
    )
}.json(deserializer)

public inline fun <reified T> Activity.aboutMe(
    count: Int? = null,
    vararg options: Option
): JsonGeneralApiAction<T> = aboutMe(deserializer(), count, *options)
