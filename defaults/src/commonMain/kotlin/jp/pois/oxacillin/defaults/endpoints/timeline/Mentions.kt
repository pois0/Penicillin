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

package jp.pois.oxacillin.defaults.endpoints.timeline

import jp.pois.oxacillin.core.request.action.JsonArrayApiAction
import jp.pois.oxacillin.defaults.endpoints.Timeline
import jp.pois.oxacillin.defaults.models.Status
import jp.pois.oxacillin.endpoints.Option
import jp.pois.oxacillin.endpoints.common.TweetMode
import jp.pois.oxacillin.endpoints.timeline
import jp.pois.oxacillin.endpoints.timeline.mentionsTimeline

/**
 * Returns the 20 most recent mentions (Tweets containing a users's @screen_name) for the authenticating user.
 * The timeline returned is the equivalent of the one seen when you view [your mentions](http://twitter.com/mentions) on twitter.com.
 * This method can only return up to 800 tweets.
 * See [Working with Timelines](https://developer.twitter.com/en/docs/tweets/timelines/guides/working-with-timelines) for instructions on traversing timelines.
 *
 * [Twitter API reference](https://developer.twitter.com/en/docs/tweets/timelines/api-reference/get-statuses-mentions_timeline)
 *
 * @param count Specifies the number of Tweets to try and retrieve, up to a maximum of 200. The value of count is best thought of as a limit to the number of tweets to return because suspended or deleted content is removed after the count has been applied. We include retweets in the count, even if include_rts is not supplied. It is recommended you always send include_rts=1 when using this API method.
 * @param sinceId Returns results with an ID greater than (that is, more recent than) the specified ID. There are limits to the number of Tweets which can be accessed through the API. If the limit of Tweets has occured since the since_id, the since_id will be forced to the oldest ID available.
 * @param maxId Returns results with an ID less than (that is, older than) or equal to the specified ID.
 * @param trimUser When set to either true , t or 1 , each tweet returned in a timeline will include a user object including only the status authors numerical ID. Omit this parameter to receive the complete user object.
 * @param includeEntities The entities node will not be included when set to false.
 * @param includeRTs Not documented yet.
 * @param includeMyRetweet Not documented yet.
 * @param tweetMode Not documented yet.
 * @param options Optional. Custom parameters of this request.
 * @receiver [Timeline] endpoint instance.
 * @return [JsonArrayApiAction] for [Status] model.
 */
public inline fun Timeline.mentionsTimeline(
    count: Int? = null,
    sinceId: Long? = null,
    maxId: Long? = null,
    trimUser: Boolean? = null,
    includeEntities: Boolean? = null,
    includeRTs: Boolean? = null,
    includeMyRetweet: Boolean? = null,
    tweetMode: TweetMode = TweetMode.Default,
    includeCardUri: Boolean? = null,
    vararg options: Option
): JsonArrayApiAction<Status> = client.timeline.mentionsTimeline(count, sinceId, maxId, trimUser, includeEntities, includeRTs, includeMyRetweet, tweetMode, includeCardUri, *options)

/**
 * Shorthand property to [Timeline.mentionsTimeline].
 * @see Timeline.mentionsTimeline
 */
public val Timeline.mentionsTimeline: JsonArrayApiAction<Status>
    get() = mentionsTimeline()
