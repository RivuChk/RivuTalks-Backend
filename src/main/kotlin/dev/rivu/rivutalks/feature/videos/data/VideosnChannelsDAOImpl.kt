package dev.rivu.rivutalks.feature.videos.data

import dev.rivu.rivutalks.db.entity.EntityChannel
import dev.rivu.rivutalks.db.entity.EntityVideo
import dev.rivu.rivutalks.db.entity.toModel
import dev.rivu.rivutalks.db.table.Channels
import dev.rivu.rivutalks.db.table.Videos
import dev.rivu.rivutalks.feature.videos.model.VideoContent
import org.jetbrains.exposed.sql.Expression
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import toModel
import java.util.*
import javax.swing.SortOrder

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
        EntityChannel.all()
            .sortedByDescending { it.featured }
            .map {
                it.toModel()
            }
    }

    override suspend fun getAllVideos(): List<VideoContent> = transaction {
        EntityVideo.all()
            .sortedByDescending { it.featured }
            .map {
                it.toModel()
            }
    }

    override suspend fun addVideoChannel(content: VideoContent) {

        when (content) {
            is VideoContent.Video -> transaction {
                EntityVideo.new {
                    url = content.url
                    title = content.title
                    description = content.description
                    featured = content.featured
                }
            }
            is VideoContent.Channel -> transaction {
                EntityChannel.new {
                    url = content.url
                    title = content.title
                    description = content.description
                    featured = content.featured
                }
            }
        }
    }
}