package dev.rivu.rivutalks.feature.videos.model

import kotlinx.serialization.Serializable

@Serializable
sealed class AddVideoChannelRequest {
    abstract val url: String
    abstract val title: String
    abstract val description: String?
    abstract val featured: Boolean
    abstract val isYoutube: Boolean
    abstract val cover: String?

    @Serializable
    data class AddVideoRequest(
        override val url: String,
        override val title: String,
        override val description: String?,
        override val featured: Boolean,
        override val isYoutube: Boolean,
        override val cover: String?,
    ): AddVideoChannelRequest()

    @Serializable
    data class AddChannelRequest(
        override val url: String,
        override val title: String,
        override val description: String?,
        override val featured: Boolean,
        override val isYoutube: Boolean,
        override val cover: String?,
    ): AddVideoChannelRequest()
}