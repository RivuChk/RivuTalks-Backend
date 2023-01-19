package dev.rivu.rivutalks.feature.videos

import dev.rivu.rivutalks.feature.videos.model.AddVideoChannelRequest
import dev.rivu.rivutalks.feature.videos.model.VideoListResponseModel
import dev.rivu.rivutalks.feature.videos.model.VideoResponseModel
import toModel
import toResponse

class VideosnChannelService(
    private val repository: VideosRepository
) {
    suspend fun getVideo(id: String): VideoResponseModel {
        return repository.getVideo(id).toResponse()
    }

    suspend fun getChannel(id: String): VideoResponseModel {
        return repository.getChannel(id).toResponse()
    }

    suspend fun getAllVideosnChannels(): VideoListResponseModel {
        return repository.getAllVideosnChannels().toResponse()
    }

    suspend fun getAllChannels(): VideoListResponseModel {
        return repository.getAllChannels().toResponse()
    }

    suspend fun getAllVideos(): VideoListResponseModel {
        return repository.getAllVideos().toResponse()
    }

    suspend fun addVideoChannel(content: AddVideoChannelRequest) {
        repository.addVideoChannel(content.toModel())
    }
}