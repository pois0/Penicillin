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

package jp.pois.oxacillin.defaults.endpoints.trends

import jp.pois.oxacillin.core.request.action.JsonArrayApiAction
import jp.pois.oxacillin.defaults.endpoints.Trends
import jp.pois.oxacillin.defaults.models.TrendPlace
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.trends
import jp.pois.oxacillin.endpoints.trends.TrendExclude
import jp.pois.oxacillin.endpoints.trends.place

/**
 * Returns the top 50 trending topics for a specific WOEID, if trending information is available for it.
 * The response is an array of trend objects that encode the name of the trending topic, the query parameter that can be used to search for the topic on Twitter Search, and the Twitter Search URL.
 * This information is cached for 5 minutes. Requesting more frequently than that will not return any more data, and will count against rate limit usage.
 * The tweet_volume for the last 24 hours is also returned for many trends if this is available.
 * 
 * [Twitter API reference](https://developer.twitter.com/en/docs/trends/trends-for-location/api-reference/get-trends-place)
 * 
 * @param id The [Yahoo! Where On Earth ID](http://developer.yahoo.com/geo/geoplanet/) of the location to return trending information for. Global information is available by using 1 as the WOEID.
 * @param exclude Setting this equal to hashtags will remove all hashtags from the trends list.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Trends] endpoint instance.
 * @return [JsonArrayApiAction] for [TrendPlace] model.
 */
public inline fun Trends.place(
    id: Long,
    exclude: TrendExclude = TrendExclude.Default,
    vararg options: Option
): JsonArrayApiAction<TrendPlace> = client.trends.place(id, exclude, *options)
