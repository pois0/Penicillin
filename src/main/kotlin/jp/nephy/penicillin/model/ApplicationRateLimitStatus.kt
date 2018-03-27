package jp.nephy.penicillin.model

import com.google.gson.JsonObject
import jp.nephy.jsonkt.JsonModel
import jp.nephy.jsonkt.byModel
import jp.nephy.jsonkt.byNullableString
import jp.nephy.jsonkt.jsonObject


class ApplicationRateLimitStatus(override val json: JsonObject): JsonModel {
    val accessToken by json["rate_limit_content"].jsonObject.byNullableString("access_token")
    val application by json["rate_limit_content"].jsonObject.byNullableString
    val resources by json.byModel<Resources>()
}
