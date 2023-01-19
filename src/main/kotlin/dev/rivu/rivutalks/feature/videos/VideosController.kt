package dev.rivu.rivutalks.feature.videos

import dev.rivu.rivutalks.feature.videos.model.AddVideoChannelRequest
import dev.rivu.rivutalks.feature.videos.model.VideoListResponse
import dev.rivu.rivutalks.feature.videos.model.VideoResponse
import dev.rivu.rivutalks.response.HttpResponse
import dev.rivu.rivutalks.response.Success
import dev.rivu.rivutalks.utils.handleResponse


class VideosController(
    private val videosnChannelService: VideosnChannelService
) {
    suspend fun getVideo(id: String): HttpResponse<VideoResponse> = handleResponse {
        Success(
            VideoResponse(
                content = videosnChannelService.getVideo(id)
            )
        )
    }

    suspend fun getChannel(id: String): HttpResponse<VideoResponse> = handleResponse {
        Success(
            VideoResponse(
                content = videosnChannelService.getChannel(id)
            )
        )
    }

    suspend fun getAllVideosnChannels(): HttpResponse<VideoListResponse> = handleResponse {
        Success(
            VideoListResponse(
                contents = videosnChannelService.getAllVideosnChannels().contents
            )
        )
    }

    suspend fun getAllChannels(): HttpResponse<VideoListResponse> = handleResponse {
        Success(
            VideoListResponse(
                contents = videosnChannelService.getAllChannels().contents
            )
        )
    }

    suspend fun getAllVideos(): HttpResponse<VideoListResponse> = handleResponse {
        Success(
            VideoListResponse(
                contents = videosnChannelService.getAllVideos().contents
            )
        )
    }

    suspend fun addVideoChannel(content: AddVideoChannelRequest) = handleResponse {
        videosnChannelService.addVideoChannel(content)
        getAllVideosnChannels()
    }
}