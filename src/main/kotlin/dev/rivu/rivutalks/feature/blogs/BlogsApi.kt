package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.plugins.RivuTalksRoutes
import dev.rivu.rivutalks.utils.returnResponse
import io.ktor.server.locations.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject


fun Route.BlogsApi() {

    val controller by inject<BlogsController>()

    get<RivuTalksRoutes.Blogs> {
        returnResponse(controller.getAllBlogs())
    }

    get<RivuTalksRoutes.Blogs.BySiteId> {
        returnResponse(controller.getBlogsForSite(it.siteId))
    }

    get<RivuTalksRoutes.Blogs.Blog> {
        returnResponse(controller.getBlogDetails(it.blogId))
    }

    get<RivuTalksRoutes.Sites> {
        returnResponse(controller.getAllSites())
    }

    get<RivuTalksRoutes.Sites.BySiteId> {
        returnResponse(controller.getSiteDetails(it.siteId))
    }

}