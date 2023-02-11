package dev.rivu.rivutalks.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.cors.routing.*

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