package dev.rivu.rivutalks.plugins

import dev.rivu.rivutalks.core.Paths
import dev.rivu.rivutalks.feature.aboutme.AboutMeAPI
import dev.rivu.rivutalks.feature.blogs.BlogsApi
import dev.rivu.rivutalks.feature.entrypoints.EntryPointAPI
import dev.rivu.rivutalks.feature.syncrss.SyncRssApi
import dev.rivu.rivutalks.feature.videos.model.VideosApi
import io.ktor.server.locations.*
import io.ktor.server.routing.*

@Location("/api/v1")
object RivuTalksRoutes {
    @Location(Paths.Blogs)
    object Blogs {
        @Location("site/{siteId}")
        data class BySiteId(val siteId: String)

        @Location("{blogId}")
        data class Blog(val blogId: String)
    }

    @Location(Paths.Videos)
    object Videos {
        @Location("{videoId}")
        data class GetVideo(val videoId: String)

        @Location("addVideo")
        object AddVideo
    }

    @Location(Paths.VideoContents)
    object VideosNChannels

    @Location(Paths.Channels)
    object Channels {
        @Location("{channelId}")
        data class GetChannel(val channelId: String)

        @Location("addChannel")
        object AddChannel
    }

    @Location(Paths.Sites)
    object Sites {
        @Location("{siteId}")
        data class BySiteId(val siteId: String)
    }

    @Location("sync-rss/{syncKey}")
    data class SyncRss(val syncKey: String)

    @Location("entry-points")
    object EntryPoint

    @Location("about-me")
    object AboutMe
}


fun Routing.MainRoute() {
    BlogsApi()
    SyncRssApi()
    VideosApi()
    EntryPointAPI()
    AboutMeAPI()
}