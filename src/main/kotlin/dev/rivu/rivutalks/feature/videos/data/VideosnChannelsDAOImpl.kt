package dev.rivu.rivutalks.feature.videos.data

import dev.rivu.rivutalks.db.entity.EntityChannel
import dev.rivu.rivutalks.db.entity.EntityVideo
import dev.rivu.rivutalks.db.table.Channels
import dev.rivu.rivutalks.db.table.Videos
import dev.rivu.rivutalks.feature.videos.model.VideoContent
import java.util.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import toModel

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
                addUpdateVideo(content)
            }
            is VideoContent.Channel -> transaction {
                addUpdateChannel(content)
            }
        }
    }

    fun addUpdateVideo(content: VideoContent.Video) {
        val existingVideoCount = Videos.select {
            Videos.url eq content.url
        }.count()

        if (existingVideoCount >= 1) {
            Videos.update({
                Videos.url eq content.url
            }) {
                it[title] = content.title
                it[description] = content.description
                it[featured] = content.featured
                it[cover] = content.cover
                it[isYoutube] = content.isYoutube
            }
        } else {
            EntityVideo.new {
                url = content.url
                title = content.title
                description = content.description
                featured = content.featured
                cover = content.cover
                isYoutube = content.isYoutube
            }
        }
    }

    fun addUpdateChannel(content: VideoContent.Channel) {
        val existingVideoCount = Channels.select {
            Channels.url eq content.url
        }.count()

        if (existingVideoCount >= 1) {
            Channels.update({
                Channels.url eq content.url
            }) {
                it[title] = content.title
                it[description] = content.description
                it[featured] = content.featured
                it[cover] = content.cover
                it[isYoutube] = content.isYoutube
            }
        } else {
            EntityChannel.new {
                url = content.url
                title = content.title
                description = content.description
                featured = content.featured
                cover = content.cover
                isYoutube = content.isYoutube
            }
        }
    }
}