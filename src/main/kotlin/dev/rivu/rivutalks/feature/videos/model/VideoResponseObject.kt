package dev.rivu.rivutalks.feature.videos.model

import dev.rivu.rivutalks.response.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class VideoResponseModel(
    val url: String,
    val title: String,
    val description: String?,
    val featured: Boolean,
    val type: ContentType,
    val isYoutube: Boolean,
    val cover: String?,
)

@Serializable
enum class ContentType {
    VIDEO, CHANNEL
}

@Serializable
data class VideoListResponseModel(
    val contents: List<VideoResponseModel>
)

@Serializable
data class VideoResponse(
        val content: VideoResponseModel
): BaseResponse(isSuccess = true)

@Serializable
data class VideoListResponse(
        val contents: List<VideoResponseModel>
): BaseResponse(isSuccess = true)
