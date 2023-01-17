package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.models.*
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
    suspend fun getBlogDetails(blogId: String): HttpResponse<BlogResponse> = handleResponse {
        Success(BlogResponse(blogsService.getBlog(blogId)))
    }
    suspend fun getAllSites(): HttpResponse<SiteListResponse> = handleResponse {
        Success(SiteListResponse(blogsService.getAllSites()))
    }
    suspend fun getSiteDetails(siteId: String): HttpResponse<SiteResponse> = handleResponse {
        Success(SiteResponse(blogsService.getSitesById(siteId)))
    }
}