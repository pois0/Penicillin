package jp.nephy.penicillin.response

import jp.nephy.jsonkt.JsonModel
import jp.nephy.penicillin.misc.AccessLevel
import jp.nephy.penicillin.misc.RateLimit
import okhttp3.Request
import okhttp3.Response


class ResponseList<T: JsonModel>(override val content: String, override val request: Request, override val response: Response): ArrayList<T>(), IResult {
    private val responseHeaders= response.headers()

    override val rateLimit = RateLimit(responseHeaders)
    override val accessLevel = AccessLevel.getLevel(responseHeaders)
    override val responseTimeMs = responseHeaders["x-response-time"]?.toIntOrNull()
}
