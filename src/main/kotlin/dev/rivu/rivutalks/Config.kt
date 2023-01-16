package dev.rivu.rivutalks

import io.ktor.server.config.*

class Config constructor(config: ApplicationConfig) {

    val DATABASE_HOST = config.property("database.host").getString()
    val DATABASE_PORT = config.property("database.port").getString()
    val DATABASE_NAME = config.property("database.name").getString()
    val DATABASE_USER = config.property("database.user").getString()
    val DATABASE_PASSWORD = config.property("database.password").getString()
    val DATABASE_DRIVER = config.property("database.driver").getString()
    val DATABASE_MAX_POOL_SIZE = config.property("database.maxPoolSize").getString()
}
