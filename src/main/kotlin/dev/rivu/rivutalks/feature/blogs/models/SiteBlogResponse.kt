package dev.rivu.rivutalks.feature.blogs.models

import dev.rivu.rivutalks.response.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class SiteBlogResponse(
    val sites: Map<Site, Blog>
) : BaseResponse(true)
