package dev.rivu.rivutalks.feature.entrypoints

import dev.rivu.rivutalks.core.Paths
import dev.rivu.rivutalks.feature.entrypoints.model.EntryPointItem
import dev.rivu.rivutalks.feature.entrypoints.model.EntryPointsResponse
import dev.rivu.rivutalks.response.HttpResponse
import dev.rivu.rivutalks.response.Success
import dev.rivu.rivutalks.utils.handleResponse

class EntrypointsController {
    suspend fun getEntryPoints(): HttpResponse<EntryPointsResponse> = handleResponse {

        //TODO Replace this with proper Dynamic Paths
        val entryPoints: MutableList<EntryPointItem> = mutableListOf()
        entryPoints.add(
            EntryPointItem(
                name = "Blogs",
                rootPath = Paths.Blogs,
                childPaths = listOf(
                    "/{blogId}", "site/{siteId}"
                ),
                shoudShowinNav = true,
            )
        )
        entryPoints.add(
            EntryPointItem(
                name = "Videos & Channels",
                rootPath = Paths.VideoContents,
                shoudShowinNav = true,
            )
        )
        entryPoints.add(
            EntryPointItem(
                name = "Sites",
                rootPath = Paths.Sites,
                childPaths = listOf(
                    "/{siteId}"
                ),
                shoudShowinNav = true,
            )
        )
        entryPoints.add(
            EntryPointItem(
                name = "Videos",
                rootPath = Paths.Videos,
                childPaths = listOf(
                    "{videoId}"
                ),
                shoudShowinNav = false,
            )
        )
        entryPoints.add(
            EntryPointItem(
                name = "Channels",
                rootPath = Paths.Channels,
                childPaths = listOf(
                    "{channelId}"
                ),
                shoudShowinNav = true,
            )
        )
        entryPoints.add(
            EntryPointItem(
                name = "About Me",
                rootPath = Paths.AboutMe,
                shoudShowinNav = true,
            )
        )
        //End-TODO: Replace till here with dynamic Entry Points

        Success(
            EntryPointsResponse(
                entryPoints = entryPoints.sortedByDescending {
                    it.shoudShowinNav
                }
            )
        )
    }
}