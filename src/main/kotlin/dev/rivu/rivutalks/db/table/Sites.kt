package dev.rivu.rivutalks.db.table

import org.jetbrains.exposed.dao.id.UUIDTable

object Sites : UUIDTable() {
    val url = varchar("url", length = 250)
    val title = varchar("title", length = 250)
    val description = text("description")
}