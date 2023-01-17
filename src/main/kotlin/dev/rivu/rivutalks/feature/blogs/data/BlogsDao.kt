package dev.rivu.rivutalks.feature.blogs.data

import dev.rivu.rivutalks.db.entity.EntitySite
import dev.rivu.rivutalks.feature.blogs.models.AddBlog
import dev.rivu.rivutalks.feature.blogs.models.AddSite
import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.Site

interface BlogsDao {
    suspend fun getAllBlogs(): List<Blog>
    suspend fun addBlog(blog: AddBlog): String
    suspend fun addBlogs(blogs: List<AddBlog>): List<String>
    suspend fun getBlogsForSite(siteId: String): List<Blog>
    suspend fun getBlogsForSite(site: Site): List<Blog>
    suspend fun getAllSites(): Map<Site, List<Blog>>
    suspend fun getSitesById(siteId: String): Pair<Site, List<Blog>>
    suspend fun getBlog(blogId: String): Blog
    fun createSite(site: AddSite): EntitySite
    fun findSite(site: AddSite): EntitySite?
}