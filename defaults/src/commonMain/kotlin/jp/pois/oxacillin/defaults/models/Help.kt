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

package jp.pois.oxacillin.defaults.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject

public class Help private constructor() {
    @Serializable
    public data class Configuration(
        @SerialName("characters_reserved_per_media") public val charactersReservedPerMedia: Int,
        @SerialName("client_event_url") public val clientEventUrl: String,
        @SerialName("dm_test_character_limit") public val dmTestCharacterLimit: Int,
        @SerialName("max_media_per_upload") public val maxMediaPerUpload: Int,
        @SerialName("non_username_paths") public val nonUsernamePaths: List<String>,
        @SerialName("photo_size_limit") public val photoSizeLimit: Int,
        @SerialName("photo_sizes") public val photoSizes: Photo,
        @SerialName("short_url_length") public val shortUrlLength: Int,
        @SerialName("short_url_length_https") public val shortUrlLengthHttps: Int
    )

    @Serializable
    public data class Language(
        public val code: String,
        public val status: String,
        public val name: String
    )

    @Serializable
    public data class Privacy(
        public val privacy: String
    )

    @Serializable
    public data class Tos(
        public val tos: String
    )

    @Serializable
    public data class Settings(
        public val versions: JsonObject,
        @SerialName("feature_switches_version") public val featureSwitchesVersion: String,
        @SerialName("experiments") public val experimentVersion: String,
        @SerialName("settings") public val settingsVersion: String,
        public val impressions: JsonArray,
        public val config: JsonObject
    )
}
