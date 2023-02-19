package dev.rivu.rivutalks.plugins

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.cors.routing.CORS

fun Application.configureCORS() {
    val config = environment.config
    val corsConfig = config.config("cors")
    val allowedOrigins = corsConfig.property("allowedOrigins").getString().split(",").map {
        it.trim()
    }
    install(CORS) {
        allowedOrigins.forEach {
            allowHost(host = it, schemes = listOf("http", "https"))
            allowHeader(HttpHeaders.ContentType)
        }
        allowedOrigins.forEach {
            println("allowed origins $it")
        }
    }
}