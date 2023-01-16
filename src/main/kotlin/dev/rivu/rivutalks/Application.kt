package dev.rivu.rivutalks

import dev.rivu.rivutalks.db.DBConfig
import dev.rivu.rivutalks.db.initDatabase
import dev.rivu.rivutalks.feature.blogs.data.blogsDataModule
import dev.rivu.rivutalks.feature.blogs.di.blogsModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.rivu.rivutalks.plugins.configureHTTP
import dev.rivu.rivutalks.plugins.configureRouting
import dev.rivu.rivutalks.plugins.configureSerialization
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main(args: Array<String>): Unit = EngineMain.main(args)



fun Application.module() {
// Install Ktor features
    install(Koin) {
        slf4jLogger()
        modules(blogsModule, blogsDataModule)
    }

    configureHTTP()
    configureSerialization()
    configureRouting()

    init()
}

fun Application.init() {
    val config = environment.config
    val databaseConfig = config.config("database")
    val dbConfig = DBConfig(
        host = databaseConfig.property("host").getString(),
        port = databaseConfig.property("port").getString(),
        name = databaseConfig.property("name").getString(),
        user = databaseConfig.property("user").getString(),
        password = databaseConfig.property("password").getString(),
        driver = databaseConfig.property("driver").getString(),
        maxPoolSize = databaseConfig.property("maxPoolSize").getString().toInt()
    )
    initDatabase(dbConfig)
}
