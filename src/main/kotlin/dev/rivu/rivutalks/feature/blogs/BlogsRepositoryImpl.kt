package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.data.BlogsDao
import dev.rivu.rivutalks.feature.blogs.models.AddBlog
import dev.rivu.rivutalks.feature.blogs.models.AddSite
import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.Site
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.joda.time.DateTime

class BlogsRepositoryImpl(private val blogsDao: BlogsDao) : BlogsRepository {

    override suspend fun getAllBlogs(): List<Blog> {
        return blogsDao.getAllBlogs()
    }

    override suspend fun getBlogsForSite(siteId: String): List<Blog> {
        return blogsDao.getBlogsForSite(siteId)
    }

    override suspend fun getBlogsForSite(site: Site): List<Blog> {
        return blogsDao.getBlogsForSite(site)
    }
}