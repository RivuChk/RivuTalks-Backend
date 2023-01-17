package dev.rivu.rivutalks.feature.blogs.models

import dev.rivu.rivutalks.response.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class BlogListResponse(
    val blogs: List<Blog>
) : BaseResponse(true)

@Serializable
data class BlogResponse(
    val blog: Blog
) : BaseResponse(true)

@Serializable
data class SiteResponse(
    val id: String,
    val url: String,
    val title: String,
    val description: String?,
    val blogs: List<Blog>
) : BaseResponse(true) {
    @Serializable
    data class Blog(
        val id: String,
        val url: String,
        val publishDate: Long,
        val featureImage: String,
        val title: String,
        val summary: String,
    )

    constructor(siteDetails: Pair<Site, List<dev.rivu.rivutalks.feature.blogs.models.Blog>>) : this(
        id = siteDetails.first.id,
        url = siteDetails.first.url,
        title = siteDetails.first.title,
        description = siteDetails.first.description,
        blogs = siteDetails.second.map {
            Blog(
                id = it.id,
                url = it.url,
                publishDate = it.publishDate,
                featureImage = it.featureImage,
                title = it.title,
                summary = it.summary,
            )
        }
    )
}

@Serializable
data class SiteListResponse(
    val sites: List<SiteResponse>
) : BaseResponse(true) {
    constructor(sitesDetails: Map<Site, List<Blog>>): this(
        sitesDetails.entries.toList().map {
            SiteResponse(Pair(it.key, it.value))
        }
    )
}
