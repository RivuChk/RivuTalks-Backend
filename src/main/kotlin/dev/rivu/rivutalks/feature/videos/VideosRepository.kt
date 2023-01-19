package dev.rivu.rivutalks.feature.videos

import dev.rivu.rivutalks.feature.videos.model.VideoContent

interface VideosRepository {
    suspend fun getVideo(id: String): VideoContent
    suspend fun getChannel(id: String): VideoContent
    suspend fun getAllVideosnChannels(): List<VideoContent>
    suspend fun getAllChannels(): List<VideoContent>
    suspend fun getAllVideos(): List<VideoContent>
    suspend fun addVideoChannel(content: VideoContent)
}