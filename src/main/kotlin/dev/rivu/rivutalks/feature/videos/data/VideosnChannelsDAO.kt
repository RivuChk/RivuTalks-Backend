package dev.rivu.rivutalks.feature.videos.data

import dev.rivu.rivutalks.feature.videos.model.VideoContent

interface VideosnChannelsDAO {
    suspend fun getVideo(id: String): VideoContent
    suspend fun getChannel(id: String): VideoContent
    suspend fun getAllVideosnChannels(): List<VideoContent>
    suspend fun getAllChannels(): List<VideoContent>
    suspend fun getAllVideos(): List<VideoContent>
    suspend fun addVideoChannel(content: VideoContent)
}