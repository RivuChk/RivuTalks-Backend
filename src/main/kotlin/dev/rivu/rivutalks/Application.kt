package dev.rivu.rivutalks

import dev.rivu.rivutalks.feature.blogs.di.blogsModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.rivu.rivutalks.plugins.configureHTTP
import dev.rivu.rivutalks.plugins.configureRouting
import dev.rivu.rivutalks.plugins.configureSerialization
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}


fun Application.module() {
// Install Ktor features
    install(Koin) {
        slf4jLogger()
        modules(blogsModule)
    }

    configureHTTP()
    configureSerialization()
    configureRouting()
}
