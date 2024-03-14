package com.jinukeu.core.model

import androidx.compose.runtime.Stable

data class BookCollection(
  val total: Long,
  val bookList: List<Book>,
)

@Stable
data class Book(
  val title: String,
  val subtitle: String,
  val isbn13: String,
  val price: String,
  val image: String,
  val url: String,
)
