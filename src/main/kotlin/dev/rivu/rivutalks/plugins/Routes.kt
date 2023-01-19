package dev.rivu.rivutalks.plugins

import dev.rivu.rivutalks.feature.blogs.BlogsApi
import dev.rivu.rivutalks.feature.syncrss.SyncRssApi
import dev.rivu.rivutalks.feature.videos.model.VideosApi
import io.ktor.server.locations.*
import io.ktor.server.routing.*

@Location("/api/v1")
object RivuTalksRoutes {
    @Location("blogs")
    object Blogs {
        @Location("site/{siteId}")
        data class BySiteId(val siteId: String)

        @Location("{blogId}")
        data class Blog(val blogId: String)
    }

    @Location("videos")
    object Videos {
        @Location("{videoId}")
        data class GetVideo(val videoId: String)

        @Location("addVideo")
        object AddVideo
    }

    @Location("videocontents")
    object VideosNChannels

    @Location("channels")
    object Channels {
        @Location("{channelId}")
        data class GetChannel(val channelId: String)

        @Location("addChannel")
        object AddChannel
    }

    @Location("sites")
    object Sites {
        @Location("{siteId}")
        data class BySiteId(val siteId: String)
    }

    @Location("sync-rss/{syncKey}")
    data class SyncRss(val syncKey: String)
}


fun Routing.MainRoute() {
    BlogsApi()
    SyncRssApi()
    VideosApi()
}