package com.jinukeu.core.model

import androidx.compose.runtime.Stable
@Stable
data class BookDetail(
  val title: String = "",
  val subtitle: String = "",
  val authors: String = "",
  val publisher: String = "",
  val isbn10: String = "",
  val isbn13: String = "",
  val pages: String = "",
  val year: String = "",
  val rating: String = "",
  val description: String = "",
  val price: String = "",
  val image: String = "",
  val url: String = "",
  val pdf: Map<String, String> = mapOf(),
)
