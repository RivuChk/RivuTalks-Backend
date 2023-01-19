package dev.rivu.rivutalks.feature.videos.model

import dev.rivu.rivutalks.feature.videos.VideosController
import dev.rivu.rivutalks.plugins.RivuTalksRoutes
import dev.rivu.rivutalks.response.Unsuccessful
import dev.rivu.rivutalks.utils.AuthenticationException
import dev.rivu.rivutalks.utils.returnResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.locations.post
import io.ktor.server.request.*
import io.ktor.server.routing.*
import org.koin.core.qualifier.named
import org.koin.ktor.ext.inject


fun Route.VideosApi() {

    val controller by inject<VideosController>()
    val syncKey by inject<String>(named("sync_key"))

    get<RivuTalksRoutes.Videos> {
        returnResponse(controller.getAllVideos())
    }

    get<RivuTalksRoutes.VideosNChannels> {
        returnResponse(controller.getAllVideosnChannels())
    }

    get<RivuTalksRoutes.Channels> {
        returnResponse(controller.getAllChannels())
    }

    get<RivuTalksRoutes.Videos.GetVideo> {
        returnResponse(controller.getVideo(it.videoId))
    }

    get<RivuTalksRoutes.Channels.GetChannel> {
        returnResponse(controller.getVideo(it.channelId))
    }

    post<RivuTalksRoutes.Videos.AddVideo> {
        val syncKey = call.request.queryParameters["syncKey"]
        if (syncKey.equals(syncKey)) {
            val content = call.receive<AddVideoChannelRequest.AddVideoRequest>()
            returnResponse(controller.addVideoChannel(content))
        } else {
            returnResponse(Unsuccessful(AuthenticationException("not authenticated"), HttpStatusCode.Forbidden))
        }
    }


    post<RivuTalksRoutes.Channels.AddChannel> { request ->
        val syncKey = call.request.queryParameters["syncKey"]
        if (syncKey.equals(syncKey)) {
            val content = call.receive<AddVideoChannelRequest.AddChannelRequest>()
            returnResponse(controller.addVideoChannel(content))
        } else {
            returnResponse(Unsuccessful(AuthenticationException("not authenticated"), HttpStatusCode.Forbidden))
        }
    }

}