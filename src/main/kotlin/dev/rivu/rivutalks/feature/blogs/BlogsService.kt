package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.Site

class BlogsService(private val blogsRepository: BlogsRepository) {
    suspend fun getAllBlogs(): List<Blog> {
        return blogsRepository.getAllBlogs()
    }
    suspend fun getBlogsForSite(siteId: String): List<Blog> {
        return blogsRepository.getBlogsForSite(siteId)
    }
    suspend fun getBlog(blogId: String): Blog {
        return blogsRepository.getBlog(blogId)
    }
    suspend fun getAllSites(): Map<Site, List<Blog>> {
        return blogsRepository.getAllSites()
    }
    suspend fun getSitesById(siteId: String): Pair<Site, List<Blog>> {
        return blogsRepository.getSitesById(siteId)
    }
}