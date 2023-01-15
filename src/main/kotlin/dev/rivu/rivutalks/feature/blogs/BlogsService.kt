package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.models.Blog

class BlogsService(private val blogsRepository: BlogsRepository) {
    suspend fun getAllBlogs(): List<Blog> {
        return blogsRepository.getAllBlogs()
    }
    suspend fun getBlogsForSite(siteId: String): List<Blog> {
        return blogsRepository.getBlogsForSite(siteId)
    }
}