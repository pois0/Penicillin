package jp.nephy.penicillin.api.endpoint

import com.github.salomonbrys.kotson.*
import com.google.gson.JsonElement
import jp.nephy.penicillin.api.AbsOAuthGet
import jp.nephy.penicillin.api.Parameter
import jp.nephy.penicillin.api.ResponseFormats
import jp.nephy.penicillin.request.handler.OAuthRequestHandler

class ApplicationRateLimitStatusModel(json: JsonElement) {
    val rateLimitContext by json.byNullableObject("rate_limit_context") // {"access_token": "701282649466245120-***"}
    val resources by json.byNullableObject // {"profile_spotlight": {"/profile_spotlight/show": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "explore": {"/explore/tiles": {"limit": 30, "remaining": 30, "reset": 1504531009}}, "lists": {"/lists/list": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/lists/memberships": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/lists/subscribers/show": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/lists/members": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/lists/subscriptions": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/lists/show": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/lists/ownerships": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/lists/subscribers": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/lists/members/show": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/lists/statuses": {"limit": 900, "remaining": 900, "reset": 1504531009}}, "application": {"/application/rate_limit_status": {"limit": 180, "remaining": 179, "reset": 1504531009}}, "mutes": {"/mutes/keywords/create": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/mutes/advanced_filters": {"limit": 100, "remaining": 100, "reset": 1504531009}, "/mutes/keywords/destroy": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/mutes/keywords/discouraged": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/mutes/users/list": {"limit": 50, "remaining": 50, "reset": 1504531009}, "/mutes/users/ids": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/mutes/keywords/list": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "business_profiles": {"/business_profiles/show": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/business_profiles/update": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "follow_search": {"/follow_search/show": {"limit": 60, "remaining": 60, "reset": 1504531009}}, "tweetdeck": {"/tweetdeck/clients/blackbird": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/tweetdeck/columns": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/tweetdeck/clients/pro": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/tweetdeck/dataminr/authtoken": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/tweetdeck/clients": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/tweetdeck/clients/blackbird/all": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/tweetdeck/clients/pro/all": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/tweetdeck/feeds": {"limit": 150, "remaining": 150, "reset": 1504531009}}, "people_discovery": {"/people_discovery/module": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/people_discovery/modules": {"limit": 75, "remaining": 75, "reset": 1504531009}}, "conversation": {"/conversation/show/:id": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "live_video_stream": {"/live_video_stream/status/:id": {"limit": 1000, "remaining": 1000, "reset": 1504531009}}, "users_derived.info": {"/users_derived.info": {"limit": 1, "remaining": 1, "reset": 1504531009}}, "translations": {"/translations/show": {"limit": 90, "remaining": 90, "reset": 1504531009}}, "friendships": {"/friendships/outgoing": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/friendships/create": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/friendships/list": {"limit": 200, "remaining": 200, "reset": 1504531009}, "/friendships/no_retweets/ids": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/friendships/lookup": {"limit": 500, "remaining": 500, "reset": 1504531009}, "/friendships/incoming": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/friendships/show": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "guide": {"/guide": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/guide/topic": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "auth": {"/auth/csrf_token": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "blocks": {"/blocks/list": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/blocks/exists": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/blocks/ids": {"limit": 50, "remaining": 50, "reset": 1504531009}}, "tfb": {"/tfb/v1/quick_promote/statuses/most_recently_active": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/tfb/v1/quick_promote/statuses/timeline": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "urls": {"/urls/expand": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/urls/click": {"limit": 450, "remaining": 450, "reset": 1504531009}}, "geo": {"/geo/similar_places": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/geo/place_page": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/geo/id/:place_id": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/geo/reverse_geocode": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/geo/search": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/geo/places": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "promoted_content": {"/promoted_content/log": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "users": {"/users/wipe_addressbook": {"limit": 10, "remaining": 10, "reset": 1504531009}, "/users/interests/timelines": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/users/phone_number_available": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/users/contributors": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/users/contributees": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/users/report_spam": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/users/contributors/pending": {"limit": 2000, "remaining": 2000, "reset": 1504531009}, "/users/send_invites_by_email": {"limit": 10, "remaining": 10, "reset": 1504531009}, "/users/show/:id": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/users/search": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/users/interests/topics": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/users/suggestions/:slug": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/users/recommendations": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/users/contributees/pending": {"limit": 200, "remaining": 200, "reset": 1504531009}, "/users/profile_banner": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/users/derived_info": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/users/email_phone_info": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/users/suggestions/:slug/members": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/users/following_followers_of": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/users/lookup": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/users/suggestions": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/users/extended_profile": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/users/reverse_lookup": {"limit": 100, "remaining": 100, "reset": 1504531009}}, "special_events": {"/special_events/world_cup_2014/settings": {"limit": 100, "remaining": 100, "reset": 1504531009}, "/special_events/world_cup_2014/countries/list": {"limit": 100, "remaining": 100, "reset": 1504531009}}, "device_following": {"/device_following/list": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/device_following/ids": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "prompts": {"/prompts/record_event": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/prompts/suggest": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "followers": {"/followers/ids": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/followers/vit/ids": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/followers/vit/list": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/followers/list": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "commerce": {"/commerce/payment_methods": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/commerce/addresses": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/commerce/products": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/commerce/profiles": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/commerce/user_profiles": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "collections": {"/collections/collection": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/follow": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/unfollow": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/update": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/destroy": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/remove": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/list": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/create": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/add": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/entries": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/curate": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/collections/show": {"limit": 1000, "remaining": 1000, "reset": 1504531009}}, "tv": {"/tv/telecasts/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/tv/shows/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "statuses": {"/statuses/retweeters/ids": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/statuses/favorited_by": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/statuses/retweets_of_me": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/statuses/show/:id": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/statuses/home_timeline": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/statuses/user_timeline": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/statuses/friends": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/statuses/retweets/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/statuses/:id/activity/summary": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/statuses/mentions_timeline": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/statuses/oembed": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/statuses/lookup": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/statuses/media_timeline": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/statuses/following_timeline": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/statuses/retweeted_by": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "stickerprovider": {"/stickerprovider/catalog": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/stickerprovider/stickers/:id": {"limit": 150, "remaining": 150, "reset": 1504531009}}, "broadcasts": {"/broadcasts/show": {"limit": 900, "remaining": 900, "reset": 1504531009}}, "custom_profiles": {"/custom_profiles/list": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/custom_profiles/show": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "webhooks": {"/webhooks/subscriptions/direct_messages": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/webhooks": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "contacts": {"/contacts/upload_and_match": {"limit": 85, "remaining": 85, "reset": 1504531009}, "/contacts/uploaded_by": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/contacts/users": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/contacts/addressbook": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/contacts/connected_users": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/contacts": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/contacts/users_and_uploaded_by": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/contacts/delete/status": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "i": {"/i/config": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "tweet_prompts": {"/tweet_prompts/report_interaction": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/tweet_prompts/show": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "moments": {"/moments/feedback": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/userlikes": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/annotate_timeline": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/like": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/list": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/delete": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/curate/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/get_recommended_tweets": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/show/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/unsubscribe": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/guide": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/curate_metadata/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/publish": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/list_user_moments": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/categories/ttt_categories": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/create": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/pivot": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/search": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/categories": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/modern_guide": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/sports/scores": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/upsert": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/update/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/users": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/permissions": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/unlike": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/list_categories": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/moments/capsule/momentID": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/moments/capsule/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/moments/subscribe": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "live_video": {"/live_video/1/:id/timeline": {"limit": 500, "remaining": 500, "reset": 1504531009}}, "help": {"/help/tos": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/help/configuration": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/help/settings": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/help/privacy": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/help/languages": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/help/experiments": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "feedback": {"/feedback/show/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/feedback/events": {"limit": 1000, "remaining": 1000, "reset": 1504531009}}, "business_experience": {"/business_experience/twitter_pro_settings/update": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/user_features": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/dashboard_settings/destroy": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/dashboard_features": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/keywords": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/inbox/interactions": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/twitter_pro_settings/show": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/twitter_pro_settings/destroy": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/inbox/show": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/business_experience/analytics/account": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/business_experience/analytics/tweets": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/business_experience/dashboard_settings/show": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/business_experience/dashboard_settings/update": {"limit": 450, "remaining": 450, "reset": 1504531009}}, "ads": {"/ads/campaigns/account_permissions": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "offers": {"/offers": {"limit": 60, "remaining": 60, "reset": 1504531009}}, "discover": {"/discover/universal": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/discover/nearby": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/discover/highlight": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/discover/home": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "friends": {"/friends/vit/ids": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/friends/following/ids": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/friends/following/list": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/friends/list": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/friends/vit/list": {"limit": 30, "remaining": 30, "reset": 1504531009}, "/friends/ids": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "streams": {"/streams/recommended_modules": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/streams/related_users": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/streams/recommended_videos": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/streams/stream": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/streams/categories": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "searchrecordings": {"/searchrecordings/list": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/searchrecordings/show": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "interests": {"/interests/suggestions": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "sandbox": {"/sandbox/account_activity/webhooks/:id/subscriptions": {"limit": 500, "remaining": 500, "reset": 1504531009}}, "schedule": {"/schedule/status/lookup": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/schedule/status/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/schedule/status/list": {"limit": 240, "remaining": 240, "reset": 1504531009}}, "drafts": {"/drafts/statuses/update": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/drafts/statuses/destroy": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/drafts/statuses/ids": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/drafts/statuses/list": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/drafts/statuses/show": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/drafts/statuses/create": {"limit": 450, "remaining": 450, "reset": 1504531009}}, "content": {"/content/recommendations": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "beta": {"/beta/timelines/custom/list": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/beta/timelines/unfollow": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/beta/timelines/custom/show": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/beta/timelines/custom/whitelisted": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/beta/timelines/follow": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/beta/timelines/timeline": {"limit": 1000, "remaining": 1000, "reset": 1504531009}}, "direct_messages": {"/direct_messages/sent": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/direct_messages/broadcasts/list": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/direct_messages/subscribers/lists/members/show": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/direct_messages/mark_read": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/direct_messages/subscribers/ids": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/direct_messages/sent_and_received": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/direct_messages/broadcasts/statuses/list": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/direct_messages": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/direct_messages/subscribers/lists/members/ids": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/direct_messages/subscribers/show": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/direct_messages/broadcasts/show": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/direct_messages/broadcasts/statuses/show": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/direct_messages/subscribers/lists/list": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/direct_messages/show": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/direct_messages/subscribers/lists/show": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/direct_messages/events/list": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/direct_messages/events/show": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "dm": {"/dm/destroy": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/dm/requests": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/dm/unread_count": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/dm/inbox_initial_state": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/dm/conversation/:id/metadata": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/dm/user_updates": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/dm/user_inbox": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/dm/inbox_timeline/:Id": {"limit": 450, "remaining": 450, "reset": 1504531009}, "/dm/conversation/:id": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/dm/permissions": {"limit": 450, "remaining": 450, "reset": 1504531009}}, "stations": {"/stations/*": {"limit": 2000, "remaining": 2000, "reset": 1504531009}}, "timeline": {"/timeline/conversation/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/retweeted_by": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/liked_by": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/icymi": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/media/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/user/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/favorites/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/reactive": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/list": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/profile/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/timeline/home": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "media": {"/media/upload": {"limit": 500, "remaining": 500, "reset": 1504531009}}, "strato": {"/strato/column/User/:id/search/searchSafetyReadonly": {"limit": 900, "remaining": 900, "reset": 1504531009}}, "news": {"/news/details": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/news/rankings": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/news/top": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "timelines": {"/timelines/follow": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/timelines/unfollow": {"limit": 1000, "remaining": 1000, "reset": 1504531009}}, "foundmedia": {"/foundmedia/search": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/foundmedia/categories/:category": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/foundmedia/categories": {"limit": 150, "remaining": 150, "reset": 1504531009}}, "push_destinations": {"/push_destinations/device": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/push_destinations/list": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "favorite_users": {"/favorite_users/ids": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/favorite_users/list": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "communities": {"/communities/1/community/:id/leave": {"limit": 5000, "remaining": 5000, "reset": 1504531009}, "/communities/1/community/:id/members": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/communities/1/communities/create": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/communities/1/community/:id/show": {"limit": 5000, "remaining": 5000, "reset": 1504531009}, "/communities/1/community/:id/join": {"limit": 5000, "remaining": 5000, "reset": 1504531009}, "/communities/1/communities/show": {"limit": 5000, "remaining": 5000, "reset": 1504531009}, "/communities/1/community/:id/timeline": {"limit": 5000, "remaining": 5000, "reset": 1504531009}}, "graph": {"/graph/app/optout/status": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "account_activity": {"/account_activity/webhooks/:id/subscriptions/all": {"limit": 500, "remaining": 500, "reset": 1504531009}, "/account_activity/webhooks/:id/subscriptions/direct_messages": {"limit": 500, "remaining": 500, "reset": 1504531009}, "/account_activity/webhooks": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/account_activity/webhooks/:id/subscriptions": {"limit": 500, "remaining": 500, "reset": 1504531009}}, "adaptive": {"/adaptive": {"limit": 900, "remaining": 900, "reset": 1504531009}}, "videos": {"/videos/suggestions": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/videos/:type/config/:id": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "account": {"/account/login_verification_enrollment": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/account/update_profile": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/account/personalization/partner_interests": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/verification": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/personalization/app_graph": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/login_verification_request": {"limit": 120, "remaining": 120, "reset": 1504531009}, "/account/personalization/download_advertiser_list": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/account/personalization/p13n_data": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/login_verification_enrollment_v2": {"limit": 100, "remaining": 100, "reset": 1504531009}, "/account/personalization/download_your_data": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/account/verify_credentials": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/account/personalization/appgraph/optout_status": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/settings": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/account/personalization/p13n_preferences": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/personalization/set_optout_cookies": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/account/personalization/twitter_interests": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "alerts": {"/alerts/landing_page": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "mob_idsync_generate": {"/mob_idsync_generate": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "favorites": {"/favorites/list": {"limit": 75, "remaining": 75, "reset": 1504531009}}, "activity": {"/activity/by_friends": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/activity/ds": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/activity/about_me": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/activity/about_me/unread": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "amplify": {"/amplify/marketplace/defaults": {"limit": 200, "remaining": 200, "reset": 1504531009}, "/amplify/categories": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/amplify/marketplace/videos": {"limit": 200, "remaining": 200, "reset": 1504531009}}, "notifications": {"/notifications/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/notifications/view/:id": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/notifications/:id/unread_count": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "related_results": {"/related_results/show/:id": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "timeline-team": {"/timeline-team/timeline/show": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/timeline-team/timelines/timeline": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/timeline-team/curation/list": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/timeline-team/timelines/custom/list": {"limit": 1000, "remaining": 1000, "reset": 1504531009}, "/timeline-team/timelines/custom/show": {"limit": 1000, "remaining": 1000, "reset": 1504531009}}, "live_event": {"/live_event/1/:id/timeline": {"limit": 5000, "remaining": 5000, "reset": 1504531009}}, "device": {"/device/install_referrer": {"limit": 18000, "remaining": 18000, "reset": 1504531009}, "/device/register": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/device/operator_signup_info": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/device/sms_verify_begin": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/device/token": {"limit": 100, "remaining": 100, "reset": 1504531009}}, "saved_searches": {"/saved_searches/destroy/:id": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/saved_searches/show/:id": {"limit": 15, "remaining": 15, "reset": 1504531009}, "/saved_searches/list": {"limit": 15, "remaining": 15, "reset": 1504531009}}, "oauth": {"/oauth/authenticate_periscope": {"limit": 150, "remaining": 150, "reset": 1504531009}, "/oauth/list": {"limit": 30, "remaining": 30, "reset": 1504531009}}, "storystream": {"/storystream/stories": {"limit": 300, "remaining": 300, "reset": 1504531009}}, "search": {"/search/tweets": {"limit": 180, "remaining": 180, "reset": 1504531009}, "/search/universal": {"limit": 900, "remaining": 900, "reset": 1504531009}, "/search/typeahead": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/search/adaptive": {"limit": 900, "remaining": 900, "reset": 1504531009}}, "trends": {"/trends/personalized": {"limit": 60, "remaining": 60, "reset": 1504531009}, "/trends/plus": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/trends/timeline": {"limit": 300, "remaining": 300, "reset": 1504531009}, "/trends/closest": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/trends/available": {"limit": 75, "remaining": 75, "reset": 1504531009}, "/trends/place": {"limit": 75, "remaining": 75, "reset": 1504531009}}, "live_pipeline": {"/live_pipeline/events": {"limit": 180, "remaining": 180, "reset": 1504531009}}, "graphql": {"/graphql": {"limit": 150, "remaining": 150, "reset": 1504531009}}}
}

class ApplicationRateLimitStatus(oauth: OAuthRequestHandler): AbsOAuthGet<ApplicationRateLimitStatusModel>(oauth) {
    override val resourceUrl = "https://api.twitter.com/1.1/account/settings.json"
    override val responseFormat = ResponseFormats.JSON
    override val isRateLimited = true
    override val requestsPer15mins = 15
    override val defaultParameter = Parameter().apply {
        put("resources", "")
    }
}