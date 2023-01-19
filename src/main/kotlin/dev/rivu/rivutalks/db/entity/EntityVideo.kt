package dev.rivu.rivutalks.db.entity

import dev.rivu.rivutalks.db.table.Videos
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class EntityVideo(id: EntityID<UUID>) : UUIDEntity(id) {
    var url by Videos.url
    var title by Videos.title
    var description by Videos.description
    var featured by Videos.featured

    companion object : UUIDEntityClass<EntityVideo>(Videos)
}

