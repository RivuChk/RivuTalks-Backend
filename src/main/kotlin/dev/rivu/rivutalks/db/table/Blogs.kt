package dev.rivu.rivutalks.db.table

import dev.rivu.rivutalks.feature.blogs.models.Site
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.jodatime.datetime

object Blogs : UUIDTable() {
    val site = reference("site", Sites)
    var url = varchar("url", length = 250)
    var publishDate = datetime("published")
    var featureImage = varchar("image", length = 500)
    var title = varchar("title", length = 250)
    var summary = text("summary")
}