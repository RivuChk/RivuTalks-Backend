package dev.rivu.rivutalks.plugins

import dev.rivu.rivutalks.feature.blogs.BlogsController
import dev.rivu.rivutalks.utils.returnResponse
import io.ktor.server.locations.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

@Location("/api/v1")
object RivuRoutes {
    @Location("blogs")
    object Blogs {
        @Location("site/{siteId}")
        data class BySiteId(val siteId: String)
    }
}

fun Routing.MainRoute() {
    BlogsApi()
}

fun Route.BlogsApi() {

    val controller by inject<BlogsController>()

    get<RivuRoutes.Blogs> {
        returnResponse(controller.getAllBlogs())
    }

    get<RivuRoutes.Blogs.BySiteId> {
        returnResponse(controller.getBlogsForSite(it.siteId))
    }

}