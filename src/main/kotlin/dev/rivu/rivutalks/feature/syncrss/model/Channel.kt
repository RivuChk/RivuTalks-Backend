package dev.rivu.rivutalks.feature.syncrss.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable

@Serializable
@JsonIgnoreProperties
data class Channel(

    var title: String? = null,
    var description: String? = null,
    var image: Image? = Image(),
    var generator: String? = null,
    var lastBuildDate: String? = null,
    var ttl: String? = null,
    var item: List<Item> = listOf()

)