package dev.rivu.rivutalks.db.table

import org.jetbrains.exposed.dao.id.UUIDTable

object Videos : UUIDTable() {
    val title = varchar("title", length = 250)
    val url = varchar("url", length = 250).uniqueIndex()
    val description = text("description").nullable()
    val cover = varchar("cover", length = 250).nullable()
    val isYoutube = bool("isyoutube").default(defaultValue = true)
    val featured = bool("featured").index()
}
