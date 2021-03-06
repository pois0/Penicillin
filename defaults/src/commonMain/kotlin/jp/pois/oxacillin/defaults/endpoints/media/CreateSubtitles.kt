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

package jp.pois.oxacillin.defaults.endpoints.media

import jp.pois.oxacillin.core.request.ApiRequest
import jp.pois.oxacillin.core.request.action.EmptyApiAction
import jp.pois.oxacillin.defaults.endpoints.Media
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.media
import jp.pois.oxacillin.endpoints.media.createSubtitles
import kotlinx.serialization.json.JsonElement

/**
 * Use this endpoint to associate uploaded subtitles to an uploaded video. You can associate subtitles to video before or after Tweeting.
 * Request flow for associating subtitle to video before the video is Tweeted : 1. Upload video using the chunked upload endpoint and get the video media_id. 2. Upload subtitle using the chunked upload endpoint with media category set to “Subtitles” and get the subtitle media_id. 3. Call this endpoint to associate the subtitle to the video. 4. Create Tweet with the video media_id.
 * Request flow for associating subtitle to video after the video is Tweeted : 1. Upload video using the chunked upload endpoint and get the video media_id. 2. Create Tweet with the video media_id. 3. Upload subtitle using the chunked upload endpoint with media category set to SUBTITLES and get the subtitle media_id. 4. Call this endpoint to associate the subtitle to the video.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/media/upload-media/api-reference/post-media-subtitles-create)
 * 
 * @param options Optional. Custom parameters of this request.
 * @receiver [Media] endpoint instance.
 * @return [EmptyApiAction].
 */
public inline fun Media.createSubtitles(
    payload: JsonElement,
    vararg options: Option
): ApiRequest = client.media.createSubtitles(payload, *options)
