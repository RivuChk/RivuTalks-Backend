package dev.rivu.rivutalks

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import dev.rivu.rivutalks.plugins.configureHTTP
import dev.rivu.rivutalks.plugins.configureRouting
import dev.rivu.rivutalks.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureHTTP()
    configureSerialization()
    configureRouting()
}
