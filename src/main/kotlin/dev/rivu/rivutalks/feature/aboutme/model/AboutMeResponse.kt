package dev.rivu.rivutalks.feature.aboutme.model

import dev.rivu.rivutalks.response.BaseResponse
import kotlinx.serialization.Serializable

@Serializable
data class AboutMeResponse (
    val headline: String,
    val aboutMeDetails: String,
): BaseResponse(isSuccess = true)
