package dev.rivu.rivutalks.plugins

import dev.rivu.rivutalks.feature.blogs.BlogsApi
import dev.rivu.rivutalks.feature.syncrss.SyncRssApi
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
}