package jp.nephy.penicillin.model

import com.google.gson.JsonObject
import jp.nephy.jsonkt.JsonModel
import jp.nephy.jsonkt.byModel

@Suppress("UNUSED")
class TrendType(override val json: JsonObject): JsonModel {
    val trend by json.byModel<TrendModule?>()
    val promotedTrend by json.byModel<PromotedTrendModule?>()
}
