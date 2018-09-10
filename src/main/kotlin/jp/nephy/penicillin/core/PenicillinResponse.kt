package jp.nephy.penicillin.core

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import io.ktor.client.request.HttpRequest
import io.ktor.client.response.HttpResponse
import io.ktor.http.Headers
import jp.nephy.jsonkt.jsonArray
import jp.nephy.penicillin.core.i18n.LocalizedString
import jp.nephy.penicillin.core.streaming.*
import jp.nephy.penicillin.models.*
import jp.nephy.penicillin.models.special.AccessLevel
import jp.nephy.penicillin.models.special.RateLimit
import java.io.Closeable

interface PenicillinResponse: Closeable {
    val request: HttpRequest
    val response: HttpResponse
    val action: PenicillinAction
    val headers: ResponseHeaders

    override fun close() {
        response.close()
    }
}

class ResponseHeaders(private val headers: Headers) {
    val responseTimeMs by lazy {
        headers["x-response-time"]?.toIntOrNull()
    }
    val accessLevel by lazy {
        AccessLevel.getLevel(headers["x-access-level"])
    }
    val rateLimit by lazy {
        RateLimit(headers["x-rate-limit-limit"], headers["x-rate-limit-remaining"], headers["x-rate-limit-reset"])
    }
}

private interface JsonResponse<M: PenicillinModel, T: JsonElement> {
    val model: Class<M>
    val json: T
}

private interface CompletedResponse {
    val content: String
}

data class PenicillinJsonObjectResponse<M: PenicillinModel>(override val model: Class<M>, val result: M, override val request: HttpRequest, override val response: HttpResponse, override val content: String, override val action: PenicillinAction): PenicillinResponse, JsonResponse<M, JsonObject>, CompletedResponse {
    override val json by lazy { result.json }
    override val headers by lazy { ResponseHeaders(response.headers) }
}

data class PenicillinJsonArrayResponse<M: PenicillinModel>(override val model: Class<M>, override val request: HttpRequest, override val response: HttpResponse, override val content: String, override val action: PenicillinAction): PenicillinResponse, JsonResponse<M, JsonArray>, CompletedResponse, ArrayList<M>() {
    override val json by lazy { jsonArray(*map { it.json }.toTypedArray()) }
    override val headers by lazy { ResponseHeaders(response.headers) }
}

data class PenicillinCursorJsonObjectResponse<M: PenicillinCursorModel>(override val model: Class<M>, val result: M, override val request: HttpRequest, override val response: HttpResponse, override val content: String, override val action: PenicillinAction): PenicillinResponse, JsonResponse<M, JsonObject>, CompletedResponse {
    override val json by lazy { result.json }
    override val headers = ResponseHeaders(response.headers)

    fun next() = byCursor(result.nextCursor)
    fun previous() = byCursor(result.previousCursor)

    fun untilLast(): List<PenicillinCursorJsonObjectResponse<M>> {
        val results = mutableListOf(this)

        var cursor = result.nextCursor
        while (cursor != 0L) {
            val response = try {
                byCursor(cursor).complete()
            } catch (e: Exception) {
                break
            }

            results.add(response)
            cursor = response.result.nextCursor
        }
        return results
    }

    fun byCursor(cursor: Long): PenicillinCursorJsonObjectAction<M> {
        if (cursor == 0L) {
            throw PenicillinLocalizedException(LocalizedString.CursorIsZero)
        }

        action.request.builder.parameter("cursor" to cursor)

        return PenicillinCursorJsonObjectAction(action.request, model)
    }
}

val List<PenicillinCursorJsonObjectResponse<CursorIds>>.allIds
    get() = flatMap { it.result.ids }
val List<PenicillinCursorJsonObjectResponse<CursorLists>>.allLists
    get() = flatMap { it.result.lists }
val List<PenicillinCursorJsonObjectResponse<CursorUsers>>.allUsers
    get() = flatMap { it.result.users }

data class PenicillinTextResponse(override val request: HttpRequest, override val response: HttpResponse, override val content: String, override val action: PenicillinAction): PenicillinResponse, CompletedResponse {
    override val headers = ResponseHeaders(response.headers)
}

data class PenicillinStreamResponse<L: StreamListener, H: StreamHandler<L>>(override val request: HttpRequest, override val response: HttpResponse, override val action: PenicillinAction): PenicillinResponse {
    override val headers = ResponseHeaders(response.headers)
    
    fun listen(listener: L): StreamProcessor<L, H> {
        @Suppress("UNCHECKED_CAST")
        val handler = when (listener) {
            is UserStreamListener -> UserStreamHandler(listener)
            is SampleStreamListener -> SampleStreamHandler(listener)
            is FilterStreamListener -> FilterStreamHandler(listener)
            is LivePipelineListener -> LivePipelineHandler(listener)
            else -> throw UnsupportedOperationException("Unsupported StreamListener: ${listener.javaClass.canonicalName}")
        } as H

        return StreamProcessor(this, handler)
    }
}
