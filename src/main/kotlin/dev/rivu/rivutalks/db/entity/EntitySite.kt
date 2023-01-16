package dev.rivu.rivutalks.db.entity

import dev.rivu.rivutalks.db.table.Sites
import dev.rivu.rivutalks.feature.blogs.models.Site
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.UUID

class EntitySite(id: EntityID<UUID>): UUIDEntity(id) {
    var url by Sites.url
    var title by Sites.title
    var description by Sites.description

    companion object : UUIDEntityClass<EntitySite>(Sites)
}

fun EntitySite.toModel(): Site = Site(
    id = id.value.toString(),
    title = title,
    url = url,
    description = description
)