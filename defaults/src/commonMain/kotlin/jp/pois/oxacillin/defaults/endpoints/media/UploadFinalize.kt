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

import jp.pois.oxacillin.core.request.action.JsonGeneralApiAction
import jp.pois.oxacillin.defaults.endpoints.Media
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.media
import jp.pois.oxacillin.endpoints.media.uploadFinalize

/**
 * The FINALIZE command should be called after the entire media file is uploaded using APPEND commands. If and (only if) the response of the FINALIZE command contains a processing_info field, it may also be necessary to use a [STATUS command](https://developer.twitter.com/en/docs/media/upload-media/api-reference/get-media-upload-status) and wait for it to return success before proceeding to Tweet creation.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/media/upload-media/api-reference/post-media-upload-finalize)
 * 
 * @param mediaId The media_id returned from the INIT command.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Media] endpoint instance.
 * @return [JsonGeneralApiAction] for [jp.pois.oxacillin.defaults.models.Media] model.
 */
public inline fun Media.uploadFinalize(
    mediaId: Long,
    mediaKey: String? = null,
    vararg options: Option
): JsonGeneralApiAction<jp.pois.oxacillin.defaults.models.Media> = client.media.uploadFinalize(mediaId, mediaKey, *options)
