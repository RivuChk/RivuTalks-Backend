package dev.rivu.rivutalks.db.entity

import dev.rivu.rivutalks.db.table.Channels
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*

class EntityChannel(id: EntityID<UUID>) : UUIDEntity(id) {
    var url by Channels.url
    var title by Channels.title
    var description by Channels.description
    var featured by Channels.featured

    companion object : UUIDEntityClass<EntityChannel>(Channels)
}