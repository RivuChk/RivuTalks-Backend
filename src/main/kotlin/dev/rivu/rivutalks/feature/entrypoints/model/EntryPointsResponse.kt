package dev.rivu.rivutalks.feature.entrypoints.model

import dev.rivu.rivutalks.response.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class EntryPointsResponse (
    val entryPoints: List<EntryPointItem>
): BaseResponse(isSuccess = true)

@Serializable
data class EntryPointItem (
    val name: String,
    val rootPath: String,
    val childPaths: List<String> = emptyList(),
    val shoudShowinNav: Boolean = false
)