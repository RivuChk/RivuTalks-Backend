package dev.rivu.rivutalks.utils

import dev.rivu.rivutalks.response.BaseResponse
import dev.rivu.rivutalks.response.HttpResponse
import dev.rivu.rivutalks.response.Success
import dev.rivu.rivutalks.response.Unsuccessful
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.util.pipeline.*


suspend fun <T : BaseResponse> PipelineContext<Unit, ApplicationCall>.returnResponse(response: HttpResponse<T>) {
    val (statusCode, data) = when (response) {
        is Success<*> -> response.statusCode to response.data
        is Unsuccessful -> response.statusCode to response.message
    }
    call.respond(statusCode, data)
}

/**
 * Handles response globally and if any Exception occurs, it maps it to the API exceptions
 */
suspend fun <T : BaseResponse> handleResponse(response: suspend () -> HttpResponse<T>): HttpResponse<T> {
    return try {
        response()
    } catch (e: Exception) {
        e.printStackTrace()
        throw when (e) {
            is UnsatisfiedRequestException -> e
            is IllegalStateException -> BadRequestException(e.message.toString())
            is ResourceNotFoundException -> NotFoundException(e.message.toString())
            else -> ServerError("Something went wrong. Failed to serve the request")
        }
    }
}
