package jp.nephy.penicillin.api.endpoint

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonElement
import jp.nephy.penicillin.api.AbsOAuthGet
import jp.nephy.penicillin.api.Parameter
import jp.nephy.penicillin.api.ResponseFormats
import jp.nephy.penicillin.request.handler.OAuthRequestHandler

class CollectionsShowModel(val json: JsonElement) {
    val objects by json.byNullableObject // {"users": {"783214": {"id": 783214, "id_str": "783214", "name": "Twitter", "screen_name": "Twitter", "location": "San Francisco, CA", "description": "Your official source for what’s happening.\n\nNeed a hand? Visit https://t.co/jTMg7YsLw5", "url": "https://t.co/gN5JJwhQy7", "entities": {"url": {"urls": [{"url": "https://t.co/gN5JJwhQy7", "expanded_url": "https://blog.twitter.com/", "display_url": "blog.twitter.com", "indices": [0, 23]}]}, "description": {"urls": [{"url": "https://t.co/jTMg7YsLw5", "expanded_url": "https://support.twitter.com", "display_url": "support.twitter.com", "indices": [63, 86]}]}}, "protected": false, "followers_count": 61896420, "fast_followers_count": 7760, "normal_followers_count": 61888660, "friends_count": 166, "listed_count": 90565, "created_at": "Tue Feb 20 14:35:54 +0000 2007", "favourites_count": 5108, "utc_offset": -25200, "time_zone": "Pacific Time (US & Canada)", "geo_enabled": true, "verified": true, "statuses_count": 6017, "media_count": 1707, "lang": "en", "contributors_enabled": false, "is_translator": false, "is_translation_enabled": false, "profile_background_color": "ACDED6", "profile_background_image_url": "http://pbs.twimg.com/profile_background_images/657090062/l1uqey5sy82r9ijhke1i.png", "profile_background_image_url_https": "https://pbs.twimg.com/profile_background_images/657090062/l1uqey5sy82r9ijhke1i.png", "profile_background_tile": true, "profile_image_url": "http://pbs.twimg.com/profile_images/875087697177567232/Qfy0kRIP_normal.jpg", "profile_image_url_https": "https://pbs.twimg.com/profile_images/875087697177567232/Qfy0kRIP_normal.jpg", "profile_banner_url": "https://pbs.twimg.com/profile_banners/783214/1503522865", "profile_link_color": "1B95E0", "profile_sidebar_border_color": "FFFFFF", "profile_sidebar_fill_color": "F6F6F6", "profile_text_color": "333333", "profile_use_background_image": true, "has_extended_profile": true, "default_profile": false, "default_profile_image": false, "pinned_tweet_ids": [], "pinned_tweet_ids_str": [], "has_custom_timelines": true, "can_media_tag": true, "followed_by": false, "following": false, "follow_request_sent": false, "notifications": false, "business_profile_state": "none", "translator_type": "regular"}}, "timelines": {"custom-905277663304192000": {"name": "LIVE_USSportsCarousel_090517", "user_id": "783214", "collection_url": "https://twitter.com/Twitter/timelines/905277663304192000", "custom_timeline_url": "https://twitter.com/Twitter/timelines/905277663304192000", "visibility": "public", "timeline_order": "curation_reverse_chron", "collection_type": "carousel", "custom_timeline_type": "carousel"}}}
    val response by json.byNullableObject // {"timeline_id": "custom-905277663304192000"}
}

class CollectionsShow(oauth: OAuthRequestHandler) : AbsOAuthGet<CollectionsShowModel>(oauth) {
    override val resourceUrl = "https://api.twitter.com/1.1/collections/show.json"
    override val responseFormat = ResponseFormats.JSON
    override val isRateLimited = true
    override val defaultParameter = Parameter()
}
