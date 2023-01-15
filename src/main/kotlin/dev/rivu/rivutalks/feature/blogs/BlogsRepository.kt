package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.Site

interface BlogsRepository {
    suspend fun getAllBlogs(): List<Blog>
    suspend fun getBlogsForSite(siteId: String): List<Blog>
    suspend fun getBlogsForSite(site: Site): List<Blog>
}