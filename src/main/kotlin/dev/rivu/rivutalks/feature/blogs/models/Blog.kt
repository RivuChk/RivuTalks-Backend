package dev.rivu.rivutalks.feature.blogs.models

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class Blog(
    val id: String,
    val site: Site,
    val url: String,
    val publishDate: String,
    val featureImage: String,
    val title: String,
    val summary: String,
)

