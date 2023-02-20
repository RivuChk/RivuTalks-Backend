package dev.rivu.rivutalks.feature.aboutme

import dev.rivu.rivutalks.plugins.RivuTalksRoutes
import dev.rivu.rivutalks.utils.returnResponse
import io.ktor.server.locations.get
import io.ktor.server.routing.Route
import org.koin.ktor.ext.inject

fun Route.AboutMeAPI() {
    val controller by inject<AboutmeController>()
    get<RivuTalksRoutes.AboutMe> {
        returnResponse(controller.getAboutMe())
    }

}