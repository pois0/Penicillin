package jp.nephy.penicillin.core.streaming

import com.google.gson.JsonObject
import jp.nephy.jsonkt.contains
import jp.nephy.jsonkt.string
import jp.nephy.penicillin.models.*
import kotlinx.coroutines.experimental.launch

private val statusEvents = arrayOf("favorite", "unfavorite", "favorited_retweet", "retweeted_retweet", "quoted_tweet")
private val listEvents = arrayOf("list_created", "list_destroyed", "list_updated", "list_member_added", "list_member_removed", "list_user_subscribed", "list_user_unsubscribed")
private val userEvents = arrayOf("follow", "unfollow", "block", "unblock", "mute", "unmute", "user_update")

class UserStreamHandler(override val listener: UserStreamListener): StreamHandler<UserStreamListener> {
    override suspend fun handle(json: JsonObject) {
        launch { listener.onRawJson(json) }
        when {
            json.contains("text") -> listener.onStatus(Status(json))
            json.contains("direct_message") -> listener.onDirectMessage(DirectMessage(json))
            json.contains("event") -> {
                val event = json["event"].string
                when (event) {
                    in statusEvents -> {
                        val statusEvent = UserStreamStatusEvent(json)
                        launch {
                            when (event) {
                                "favorite" -> listener.onFavorite(statusEvent)
                                "unfavorite" -> listener.onUnfavorite(statusEvent)
                                "favorited_retweet" -> listener.onFavoritedRetweet(statusEvent)
                                "retweeted_retweet" -> listener.onRetweetedRetweet(statusEvent)
                                "quoted_tweet" -> listener.onQuotedTweet(statusEvent)
                            }
                        }
                        launch { listener.onAnyStatusEvent(statusEvent) }
                        listener.onAnyEvent(statusEvent)
                    }
                    in listEvents -> {
                        val listEvent = UserStreamListEvent(json)
                        launch {
                            when (event) {
                                "list_created" -> listener.onListCreated(listEvent)
                                "list_destroyed" -> listener.onListDestroyed(listEvent)
                                "list_updated" -> listener.onListUpdated(listEvent)
                                "list_member_added" -> listener.onListMemberAdded(listEvent)
                                "list_member_removed" -> listener.onListMemberRemoved(listEvent)
                                "list_user_subscribed" -> listener.onListUserSubscribed(listEvent)
                                "list_user_unsubscribed" -> listener.onListUserUnsubscribed(listEvent)
                            }
                        }
                        launch { listener.onAnyListEvent(listEvent) }
                        listener.onAnyEvent(listEvent)
                    }
                    in userEvents -> {
                        val userEvent = UserStreamUserEvent(json)
                        launch {
                            when (event) {
                                "follow" -> listener.onFollow(userEvent)
                                "unfollow" -> listener.onUnfollow(userEvent)
                                "block" -> listener.onBlock(userEvent)
                                "unblock" -> listener.onUnblock(userEvent)
                                "mute" -> listener.onMute(userEvent)
                                "unmute" -> listener.onUnmute(userEvent)
                                "user_update" -> listener.onUserUpdate(userEvent)
                            }
                        }
                        launch { listener.onAnyUserEvent(userEvent) }
                        listener.onAnyEvent(userEvent)
                    }
                    else -> listener.onUnhandledData(json)
                }
            }
            json.contains("friends") -> listener.onFriends(UserStreamFriends(json))
            json.contains("delete") -> listener.onDelete(StreamDelete(json))
            json.contains("scrub_geo") -> listener.onScrubGeo(UserStreamScrubGeo(json))
            json.contains("status_withheld") -> listener.onStatusWithheld(UserStreamStatusWithheld(json))
            json.contains("limit") -> listener.onLimit(UserStreamLimit(json))
            else -> listener.onUnhandledData(json)
        }
    }
}

interface UserStreamListener: StreamListener {
    suspend fun onStatus(status: Status) {}
    suspend fun onDirectMessage(message: DirectMessage) {}

    suspend fun onAnyEvent(event: UserStreamEvent) {}

    /* Status event */
    suspend fun onAnyStatusEvent(event: UserStreamStatusEvent) {}
    suspend fun onFavorite(event: UserStreamStatusEvent) {}
    suspend fun onUnfavorite(event: UserStreamStatusEvent) {}
    suspend fun onFavoritedRetweet(event: UserStreamStatusEvent) {}
    suspend fun onRetweetedRetweet(event: UserStreamStatusEvent) {}
    suspend fun onQuotedTweet(event: UserStreamStatusEvent) {}

    /* List event */
    suspend fun onAnyListEvent(event: UserStreamListEvent) {}
    suspend fun onListCreated(event: UserStreamListEvent) {}
    suspend fun onListDestroyed(event: UserStreamListEvent) {}
    suspend fun onListUpdated(event: UserStreamListEvent) {}
    suspend fun onListMemberAdded(event: UserStreamListEvent) {}
    suspend fun onListMemberRemoved(event: UserStreamListEvent) {}
    suspend fun onListUserSubscribed(event: UserStreamListEvent) {}
    suspend fun onListUserUnsubscribed(event: UserStreamListEvent) {}

    /* User event */
    suspend fun onAnyUserEvent(event: UserStreamUserEvent) {}
    suspend fun onFollow(event: UserStreamUserEvent) {}
    suspend fun onUnfollow(event: UserStreamUserEvent) {}
    suspend fun onBlock(event: UserStreamUserEvent) {}
    suspend fun onUnblock(event: UserStreamUserEvent) {}
    suspend fun onMute(event: UserStreamUserEvent) {}
    suspend fun onUnmute(event: UserStreamUserEvent) {}
    suspend fun onUserUpdate(event: UserStreamUserEvent) {}

    /* Misc */
    suspend fun onFriends(friends: UserStreamFriends) {}
    suspend fun onDelete(delete: StreamDelete) {}
    suspend fun onScrubGeo(scrubGeo: UserStreamScrubGeo) {}
    suspend fun onStatusWithheld(withheld: UserStreamStatusWithheld) {}
    suspend fun onLimit(limit: UserStreamLimit) {}
}
