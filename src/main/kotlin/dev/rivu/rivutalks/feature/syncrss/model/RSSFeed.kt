package dev.rivu.rivutalks.feature.syncrss.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable

@Serializable
@JsonIgnoreProperties
data class RSSFeed (

  var version : String?  = null,
  var channel : Channel? = Channel()

)