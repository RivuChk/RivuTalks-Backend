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

    override suspend fun getBlog(blogId: String): Blog {
        return blogsDao.getBlog(blogId)
    }

    override suspend fun getAllSites(): Map<Site, List<Blog>> {
        return blogsDao.getAllSites()
    }

    override suspend fun getSitesById(siteId: String): Pair<Site, List<Blog>> {
        return blogsDao.getSitesById(siteId)
    }

    override suspend fun addBlogs(addBlogList: List<AddBlog>): List<String> {
        return blogsDao.addBlogs(addBlogList)
    }
}