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

package jp.pois.oxacillin.core.response

import io.ktor.client.request.HttpRequest
import io.ktor.client.statement.HttpResponse
import jp.pois.oxacillin.core.request.action.PremiumSearchJsonApiAction
import jp.pois.oxacillin.core.session.ApiClient
import jp.pois.oxacillin.endpoints.PremiumSearchEnvironment

/**
 * The [ApiResponse] that provides parsed json object with json model. This class supports premium search api operations.
 */
public data class PremiumSearchJsonObjectResponse<T>(
    override val client: ApiClient,

    /**
     * Result of response.
     */
    public val result: T,

    override val request: HttpRequest,
    override val response: HttpResponse,
    override val content: String,
    override val action: PremiumSearchJsonApiAction<T>,

    /**
     * [PremiumSearchEnvironment] which was used to acquire this response.
     */
    public val environment: PremiumSearchEnvironment
): ApiResponse<PremiumSearchJsonObjectResponse<T>>, CompletedResponse
