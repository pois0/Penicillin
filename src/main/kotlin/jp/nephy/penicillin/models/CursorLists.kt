package jp.nephy.penicillin.models

import com.google.gson.JsonObject
import jp.nephy.jsonkt.byModelList

data class CursorLists(override val json: JsonObject): PenicillinCursorModel(json) {
    val lists by json.byModelList<TwitterList>()
}
