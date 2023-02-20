package dev.rivu.rivutalks.feature.entrypoints

import dev.rivu.rivutalks.plugins.RivuTalksRoutes
import dev.rivu.rivutalks.utils.returnResponse
import io.ktor.server.locations.get
import io.ktor.server.routing.Route
import org.koin.ktor.ext.inject

fun Route.EntryPointAPI() {
    val controller by inject<EntrypointsController>()
    get<RivuTalksRoutes.EntryPoint> {
        returnResponse(controller.getEntryPoints())
    }

}