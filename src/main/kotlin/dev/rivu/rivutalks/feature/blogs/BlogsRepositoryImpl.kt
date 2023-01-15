package dev.rivu.rivutalks.feature.blogs

import dev.rivu.rivutalks.feature.blogs.models.Blog
import dev.rivu.rivutalks.feature.blogs.models.Site
import java.time.LocalDate

class BlogsRepositoryImpl : BlogsRepository {
    val blogs = listOf<Blog>(
        Blog(
            id = "",
            title = "Why Emitting State from Repository is an Anti-Pattern",
            url = "https://www.rivu.dev/why-emitting-state-from-repository-is-an-ani-pattern/",
            site = Site(
                id = "1",
                title = "Rivu Chakraborty [rivu.dev]",
                url = "https://rivu.dev",
                description = "Kotlin Advocate, Google Developer Expert, Android Dev & Enthusiast, Public Speaker, Author of Multiple Kotlin Books. ADHDer"
            ),
            publishDate = LocalDate.now().toString(),
            featureImage = "https://s3-us-east-2.amazonaws.com/rivu.dev/2020/07/ViewStateAndViewModel.jpg",
            summary = "<!--kg-card-begin: markdown--><p>In this post, as the title suggests, I&apos;ll discuss why one shouldn&apos;t emit View States (or as some people prefer to call it Resource nowadays) from Repository, and why is it Anti-Pattern IMO. While discussing that, this post will also address why returning <code>LiveData</code> from Repository</p>",
        ),
        Blog(
            id = "1234",
            title = "Breaking the ice: Service Locator and Dependency Injection Which is What",
            url = "https://www.rivu.dev/service-locator-and-dependency-injection-which-is-what/",
            site = Site(
                id = "1",
                title = "Rivu Chakraborty [rivu.dev]",
                url = "https://rivu.dev",
                description = "Kotlin Advocate, Google Developer Expert, Android Dev & Enthusiast, Public Speaker, Author of Multiple Kotlin Books. ADHDer"
            ),
            publishDate = LocalDate.now().toString(),
            featureImage = "https://s3-us-east-2.amazonaws.com/rivu.dev/2020/06/coffee-writing-computer-blogging-34600.jpg",
            summary = "<!--kg-card-begin: markdown--><p>There is a very thin lining of difference between <strong>Service Locator (in short SL)</strong> and <strong>Dependency Injection (in short DI)</strong>. Most people get confused with these terms, even I was confused with them for so long. Even more so for Android Developers, most of us often get in dilemma whether</p>"
        )
    )

    override suspend fun getAllBlogs(): List<Blog> {
        return blogs
    }

    override suspend fun getBlogsForSite(siteId: String): List<Blog> {
        return blogs
    }

    override suspend fun getBlogsForSite(site: Site): List<Blog> {
        return blogs
    }
}