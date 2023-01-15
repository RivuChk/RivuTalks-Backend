package dev.rivu.rivutalks.feature.blogs.models

import kotlinx.serialization.Serializable

@Serializable
data class Site(
    val id: String,
    val url: String,
    val title: String,
    val description: String?,
)