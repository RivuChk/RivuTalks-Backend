import dev.rivu.rivutalks.db.entity.EntityChannel
import dev.rivu.rivutalks.db.entity.EntityVideo
import dev.rivu.rivutalks.feature.videos.model.*

fun EntityVideo.toModel(): VideoContent {
    return VideoContent.Video(
        url = url,
        title = title,
        description = description,
        featured = featured
    )
}

fun EntityChannel.toModel(): VideoContent {
    return VideoContent.Channel(
        url = url,
        title = title,
        description = description,
        featured = featured
    )
}

fun VideoResponseModel.toModel(): VideoContent {
    return when (type) {
        ContentType.VIDEO -> VideoContent.Video(
            url = url,
            title = title,
            description = description,
            featured = featured
        )
        ContentType.CHANNEL -> VideoContent.Channel(
            url = url,
            title = title,
            description = description,
            featured = featured
        )
    }
}

fun VideoContent.toResponse(): VideoResponseModel {
    return VideoResponseModel(
        url = url,
        title = title,
        description = description,
        featured = featured,
        type = when (this) {
            is VideoContent.Video -> ContentType.VIDEO
            is VideoContent.Channel -> ContentType.CHANNEL
        }
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
            featured = featured
        )
        is AddVideoChannelRequest.AddVideoRequest -> VideoContent.Video(
            url = url,
            title = title,
            description = description,
            featured = featured
        )
    }
}