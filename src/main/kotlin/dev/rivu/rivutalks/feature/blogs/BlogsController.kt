package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.BlogListResponse
import dev.rivu.rivutalks.response.HttpResponse
import dev.rivu.rivutalks.response.Success
import dev.rivu.rivutalks.utils.handleResponse

class BlogsController (private val blogsService: BlogsService) {
    suspend fun getAllBlogs(): HttpResponse<BlogListResponse>  = handleResponse {
        Success(BlogListResponse(blogsService.getAllBlogs()))
    }
    suspend fun getBlogsForSite(siteId: String): HttpResponse<BlogListResponse> = handleResponse {
        Success(BlogListResponse(blogsService.getBlogsForSite(siteId)))
    }
}