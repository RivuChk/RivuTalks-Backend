package dev.rivu.rivutalks.feature.videos

import dev.rivu.rivutalks.feature.videos.data.VideosnChannelsDAO
import dev.rivu.rivutalks.feature.videos.model.VideoContent

class VideosRepositoryImpl(
    private val videosnChannelsDAO: VideosnChannelsDAO
) : VideosRepository {
    override suspend fun getVideo(id: String): VideoContent {
        return videosnChannelsDAO.getVideo(id)
    }

    override suspend fun getChannel(id: String): VideoContent {
        return videosnChannelsDAO.getChannel(id)
    }

    override suspend fun getAllVideosnChannels(): List<VideoContent> {
        return videosnChannelsDAO.getAllVideosnChannels()
    }

    override suspend fun getAllChannels(): List<VideoContent> {
        return videosnChannelsDAO.getAllChannels()
    }

    override suspend fun getAllVideos(): List<VideoContent> {
        return videosnChannelsDAO.getAllVideos()
    }

    override suspend fun addVideoChannel(content: VideoContent) {
        videosnChannelsDAO.addVideoChannel(content)
    }
}