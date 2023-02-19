package dev.rivu.rivutalks.feature.videos.model


sealed class VideoContent {

    abstract val url: String
    abstract val title: String
    abstract val description: String?
    abstract val featured: Boolean
    abstract val isYoutube: Boolean
    abstract val cover: String?

    data class Video(
        override val url: String,
        override val title: String,
        override val description: String?,
        override val featured: Boolean,
        override val isYoutube: Boolean,
        override val cover: String?,
    ): VideoContent()

    data class Channel(
        override val url: String,
        override val title: String,
        override val description: String?,
        override val featured: Boolean,
        override val isYoutube: Boolean,
        override val cover: String?,
    ): VideoContent()
}
