package dev.rivu.rivutalks.feature.videos.model


sealed class VideoContent {

    abstract val url: String
    abstract val title: String
    abstract val description: String?
    abstract val featured: Boolean
    
    data class Video(
        override val url: String,
        override val title: String,
        override val description: String?,
        override val featured: Boolean
    ): VideoContent()

    data class Channel(
        override val url: String,
        override val title: String,
        override val description: String?,
        override val featured: Boolean
    ): VideoContent()
}
