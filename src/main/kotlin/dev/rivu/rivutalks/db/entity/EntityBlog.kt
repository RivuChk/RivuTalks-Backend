package dev.rivu.rivutalks.db.entity

import dev.rivu.rivutalks.db.table.Blogs
import dev.rivu.rivutalks.feature.blogs.models.Blog
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class EntityBlog(id: EntityID<UUID>): UUIDEntity(id) {
    var site by EntitySite referencedOn Blogs.site
    var url by Blogs.url
    var publishDate by Blogs.publishDate
    var featureImage by Blogs.featureImage
    var title by Blogs.title
    var summary by Blogs.summary

    companion object : UUIDEntityClass<EntityBlog>(Blogs)
}

fun EntityBlog.toModel(): Blog {
    return Blog(
        id = id.value.toString(),
        site = site.toModel(),
        url = url,
        publishDate = publishDate.millis,
        featureImage = featureImage,
        title = title,
        summary = summary
    )
}