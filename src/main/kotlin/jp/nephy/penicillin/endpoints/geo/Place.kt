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

@file:Suppress("UNUSED", "PublicApiImplicitType")

package jp.nephy.penicillin.endpoints.geo

import jp.nephy.penicillin.core.request.action.JsonObjectApiAction
import jp.nephy.penicillin.core.request.parameters
import jp.nephy.penicillin.core.session.get
import jp.nephy.penicillin.endpoints.Geo
import jp.nephy.penicillin.endpoints.Option
import jp.nephy.penicillin.models.Place

/**
 * Returns all the information about a known [place](https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/geo-objects).
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/geo/place-information/api-reference/get-geo-id-place_id)
 *
 * @param placeId A place in the world. These IDs can be retrieved from geo/reverse_geocode.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Geo] endpoint instance.
 * @return [JsonObjectApiAction] for [Geo] model.
 */
fun Geo.place(
    placeId: String,
    vararg options: Option
) = client.session.get("/1.1/geo/id/$placeId.json") {
    parameters(*options)
}.jsonObject { Place(it, client) }
