package dev.rivu.rivutalks.feature.syncrss

import dev.rivu.rivutalks.feature.blogs.BlogsController
import dev.rivu.rivutalks.plugins.RivuTalksRoutes
import dev.rivu.rivutalks.response.Unsuccessful
import dev.rivu.rivutalks.utils.AuthenticationException
import dev.rivu.rivutalks.utils.returnResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.routing.*
import io.ktor.server.routing.application
import org.koin.ktor.ext.inject

fun Route.SyncRssApi() {
    val controller by inject<SyncRssController>()

    get<RivuTalksRoutes.SyncRss> { request ->
        val config = application.environment.config
        val SYNC_KEY = config.config("key").property("sync").getString()
        if (SYNC_KEY.equals(request.syncKey)) {
            returnResponse(controller.getAllRss())
        } else {
            returnResponse(Unsuccessful(AuthenticationException("not autthenticated"), HttpStatusCode.Forbidden))
        }
    }
}