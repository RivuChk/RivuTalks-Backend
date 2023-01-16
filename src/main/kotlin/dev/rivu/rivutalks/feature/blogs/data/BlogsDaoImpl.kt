package dev.rivu.rivutalks.feature.blogs.data

import dev.rivu.rivutalks.db.entity.EntityBlog
import dev.rivu.rivutalks.db.entity.EntitySite
import dev.rivu.rivutalks.db.entity.toModel
import dev.rivu.rivutalks.db.table.Blogs
import dev.rivu.rivutalks.db.table.Sites
import dev.rivu.rivutalks.feature.blogs.models.AddBlog
import dev.rivu.rivutalks.feature.blogs.models.AddSite
import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.Site
import org.jetbrains.exposed.sql.or
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import java.util.UUID

class BlogsDaoImpl : BlogsDao {
    override suspend fun getAllBlogs(): List<Blog> = transaction {
        EntityBlog.all().map {
            it.toModel()
        }
    }


    override suspend fun getBlogsForSite(site: Site): List<Blog> = transaction {
        EntityBlog.find { Blogs.site eq UUID.fromString(site.id) }.map {
            it.toModel()
        }
    }

    override suspend fun getBlogsForSite(siteId: String): List<Blog> = transaction {
        EntityBlog.find { Blogs.site eq UUID.fromString(siteId) }.map {
            it.toModel()
        }
    }

    override suspend fun getAllSites(): Map<Site, List<Blog>> = transaction {
        EntitySite.all()
            .map { site ->
                site.toModel() to EntityBlog.find { Blogs.site eq site.id }.map {
                    it.toModel()
                }
            }.toMap()
    }

    override suspend fun getSitesById(siteId: String): Pair<Site, List<Blog>> = transaction {
        EntitySite[UUID.fromString(siteId)]
            .let { site ->
                site.toModel() to EntityBlog.find { Blogs.site eq site.id }.map {
                    it.toModel()
                }
            }
    }

    override suspend fun addBlog(blog: AddBlog): Pair<Site, List<Blog>> = transaction {
        val siteEntity = findSite(blog.site) ?: createSite(blog.site)

        val checkExisting = EntityBlog.find {
            Blogs.url eq blog.url
        }.empty()

        if (checkExisting) {
            EntityBlog.new {
                site = siteEntity
                url = blog.url
                title = blog.title
                publishDate = DateTime(blog.publishDate)
                featureImage = blog.featureImage
                summary = blog.summary
            }
        }

        siteEntity.toModel() to EntityBlog.find { Blogs.site eq siteEntity.id }.map {
            it.toModel()
        }
    }

    override fun createSite(site: AddSite): EntitySite {
        return EntitySite.new {
            title = site.title
            url = site.url
            title = site.title
            description = site.description ?: ""
        }
    }

    override fun findSite(site: AddSite): EntitySite? {
        return EntitySite.find {
            if (site.id != null)
                    (Sites.id eq UUID.fromString(site.id)) or (Sites.url eq site.url)
            else
                Sites.url eq site.url
        }.firstOrNull()
    }
}