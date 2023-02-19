package dev.rivu.rivutalks.db.table

import org.jetbrains.exposed.dao.id.UUIDTable

object Channels : UUIDTable() {
    val title = varchar("title", length = 250)
    val url = varchar("url", length = 250).uniqueIndex()
    val description = text("description").nullable()
    val featured = bool("featured").index()
    val cover = varchar("cover", length = 250).nullable()
    val isYoutube = bool("isyoutube").default(defaultValue = true)
}