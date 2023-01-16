package dev.rivu.rivutalks.feature.blogs.models

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class AddBlog(
    val site: AddSite,
    val url: String,
    val publishDate: Long,
    val featureImage: String,
    val title: String,
    val summary: String,
)

@Serializable
data class AddSite(
    val id: String? = null,
    val url: String,
    val title: String,
    val description: String?,
)

