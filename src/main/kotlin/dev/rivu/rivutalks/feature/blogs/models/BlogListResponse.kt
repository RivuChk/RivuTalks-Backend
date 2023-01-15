package dev.rivu.rivutalks.feature.blogs.models

import dev.rivu.rivutalks.response.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class BlogListResponse(
    val blogs: List<Blog>
) : BaseResponse(true)
