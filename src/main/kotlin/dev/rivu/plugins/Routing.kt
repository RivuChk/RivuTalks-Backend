package dev.rivu.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.resources.*
import io.ktor.resources.*
import io.ktor.server.resources.Resources
import kotlinx.serialization.Serializable
import io.ktor.server.plugins.statuspages.*
import io.ktor.http.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    install(Resources)
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause", status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get<Articles> { article ->
            // Get all articles ...
            call.respond("List of articles sorted starting from ${article.sort}")
        }
        get<BlogsRequest> { request ->
            val blogs = listOf<Blog>(
                Blog(
                    id = "123",
                    title = "Why Emitting State from Repository is an Anti-Pattern",
                    link = "https://www.rivu.dev/why-emitting-state-from-repository-is-an-ani-pattern/"
                ),
                Blog(
                    id = "1234",
                    title = "Breaking the ice: Service Locator and Dependency Injection Which is What",
                    link = "https://www.rivu.dev/service-locator-and-dependency-injection-which-is-what/"
                )
            )
            if (request.blogId == null) {
                call.respond(BlogResponse(blogs))
            } else {
                val requestedBlog = blogs.find { it.id.equals(request.blogId, ignoreCase = true) }
                val response = if (requestedBlog != null)
                    call.respond(BlogResponse(data = listOf(requestedBlog)))
                else
                    call.respond(HttpStatusCode.NotFound, "blog not found")

            }
        }
    }
}

@Serializable
@Resource("/articles")
class Articles(val sort: String? = "new")

@Serializable
@Resource("/blogs")
class BlogsRequest(val blogId: String? = null)

@Serializable
data class BlogResponse(
    val data: List<Blog>
)

@Serializable
data class Blog(
    val id: String,
    val link: String,
    val title: String,
)
