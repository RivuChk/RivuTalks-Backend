package dev.rivu.rivutalks.feature.syncrss.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import kotlinx.serialization.Serializable

@Serializable
@JsonIgnoreProperties
data class Item (

  var title       : String?           = null,
  var description : String?           = null,
  var link        : String?           = null,
  var guid        : Guid?             = Guid(),
  var category    : ArrayList<String> = arrayListOf(),
  var creator     : String?           = null,
  var pubDate     : String?           = null,
  var content     : Content?          = Content(),
  var encoded     : String?           = null

)