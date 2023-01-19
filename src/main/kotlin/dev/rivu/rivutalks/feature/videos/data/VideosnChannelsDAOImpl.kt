package dev.rivu.rivutalks.feature.videos.data

import dev.rivu.rivutalks.db.entity.EntityChannel
import dev.rivu.rivutalks.db.entity.EntityVideo
import dev.rivu.rivutalks.db.entity.toModel
import dev.rivu.rivutalks.db.table.Videos
import dev.rivu.rivutalks.feature.videos.model.VideoContent
import org.jetbrains.exposed.sql.transactions.transaction
import toModel
import java.util.*

class VideosnChannelsDAOImpl : VideosnChannelsDAO {
    override suspend fun getVideo(id: String): VideoContent = transaction {
        EntityVideo.find {
            Videos.id eq UUID.fromString(id)
        }.first().toModel()
    }

    override suspend fun getChannel(id: String): VideoContent = transaction {
        EntityChannel.find {
            Videos.id eq UUID.fromString(id)
        }.first().toModel()
    }

    override suspend fun getAllVideosnChannels(): List<VideoContent> {
        return getAllChannels() + getAllVideos()
    }

    override suspend fun getAllChannels(): List<VideoContent> = transaction {
        EntityChannel.all().map {
            it.toModel()
        }
    }

    override suspend fun getAllVideos(): List<VideoContent> = transaction {
        EntityVideo.all().map {
            it.toModel()
        }
    }

    override suspend fun addVideoChannel(content: VideoContent) {

        when (content) {
            is VideoContent.Video -> transaction {
                EntityVideo.new {
                    url = url
                    title = title
                    description = description
                    featured = featured
                }
            }
            is VideoContent.Channel -> transaction {
                EntityChannel.new {
                    url = url
                    title = title
                    description = description
                    featured = featured
                }
            }
        }
    }
}