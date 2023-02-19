
import dev.rivu.rivutalks.db.entity.EntityChannel
import dev.rivu.rivutalks.db.entity.EntityVideo
import dev.rivu.rivutalks.feature.videos.model.AddVideoChannelRequest
import dev.rivu.rivutalks.feature.videos.model.ContentType
import dev.rivu.rivutalks.feature.videos.model.VideoContent
import dev.rivu.rivutalks.feature.videos.model.VideoListResponseModel
import dev.rivu.rivutalks.feature.videos.model.VideoResponseModel

fun EntityVideo.toModel(): VideoContent {
    return VideoContent.Video(
        url = url,
        title = title,
        description = description,
        featured = featured,
        isYoutube = isYoutube,
        cover = cover ?: if (isYoutube) buildDefaultYTCoverImage(url) else null,
    )
}

fun EntityChannel.toModel(): VideoContent {
    return VideoContent.Channel(
        url = url,
        title = title,
        description = description,
        featured = featured,
        isYoutube = isYoutube,
        cover = cover,
    )
}

fun VideoResponseModel.toModel(): VideoContent {
    return when (type) {
        ContentType.VIDEO -> VideoContent.Video(
            url = url,
            title = title,
            description = description,
            featured = featured,
            isYoutube = isYoutube,
            cover = cover,
        )
        ContentType.CHANNEL -> VideoContent.Channel(
            url = url,
            title = title,
            description = description,
            featured = featured,
            isYoutube = isYoutube,
            cover = cover,
        )
    }
}

fun VideoContent.toResponse(): VideoResponseModel {
    return VideoResponseModel(
        url = url,
        title = title,
        description = description,
        featured = featured,
        isYoutube = isYoutube,
        cover = cover,
        type = when (this) {
            is VideoContent.Video -> ContentType.VIDEO
            is VideoContent.Channel -> ContentType.CHANNEL
        },
        embedUrl = if (this is VideoContent.Video) buildDefaultYTEmbedUrl(url) else null
    )
}

fun List<VideoContent>.toResponse(): VideoListResponseModel {
    return VideoListResponseModel(
        contents = map {
            it.toResponse()
        }
    )
}

fun AddVideoChannelRequest.toModel(): VideoContent {
    return when (this) {
        is AddVideoChannelRequest.AddChannelRequest -> VideoContent.Channel(
            url = url,
            title = title,
            description = description,
            featured = featured,
            isYoutube = isYoutube,
            cover = cover,
        )
        is AddVideoChannelRequest.AddVideoRequest -> VideoContent.Video(
            url = url,
            title = title,
            description = description,
            featured = featured,
            isYoutube = isYoutube,
            cover = cover,
        )
    }
}

fun buildDefaultYTCoverImage(
    url: String
): String = url.let {
    val youtubeVideoId = if (it.contains("youtube.com/watch?v=", ignoreCase = true)) {
        it.substringAfter("youtube.com/watch?v=")
    } else if (it.contains("youtu.be", ignoreCase = true)) {
        it.substringAfter("youtu.be/")
    } else {
        ""
    }
    "https://i3.ytimg.com/vi/$youtubeVideoId/maxresdefault.jpg"
}

fun buildDefaultYTEmbedUrl(
    url: String
): String = url.let {
    val youtubeVideoId = if (it.contains("youtube.com/watch?v=", ignoreCase = true)) {
        it.substringAfter("youtube.com/watch?v=")
    } else if (it.contains("youtu.be", ignoreCase = true)) {
        it.substringAfter("youtu.be/")
    } else {
        ""
    }
    "https://www.youtube.com/embed/$youtubeVideoId"
}