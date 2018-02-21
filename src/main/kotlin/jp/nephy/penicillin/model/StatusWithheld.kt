package jp.nephy.penicillin.model

import com.google.gson.JsonObject
import jp.nephy.jsonkt.JsonModel
import jp.nephy.jsonkt.byLong
import jp.nephy.jsonkt.byString
import jp.nephy.jsonkt.byStringList

@Suppress("UNUSED")
class StatusWithheld(override val json: JsonObject): JsonModel {
    val userId by json["status_withheld"].byLong("user_id")
    val id by json["status_withheld"].byLong
    val timestampMs by json["status_withheld"].byString("timestamp_ms")
    val withheldInCountries by json["status_withheld"].byStringList("withheld_in_countries")
}
