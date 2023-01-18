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
import org.koin.core.qualifier.named
import org.koin.ktor.ext.inject

fun Route.SyncRssApi() {
    val controller by inject<SyncRssController>()
    val syncKey by inject<String>(named("sync_key"))

    get<RivuTalksRoutes.SyncRss> { request ->
        if (syncKey.equals(request.syncKey)) {
            returnResponse(controller.getAllRss())
        } else {
            returnResponse(Unsuccessful(AuthenticationException("not autthenticated"), HttpStatusCode.Forbidden))
        }
    }
}