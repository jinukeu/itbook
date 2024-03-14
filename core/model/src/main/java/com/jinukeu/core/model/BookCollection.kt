package com.jinukeu.core.model

import kotlinx.serialization.Serializable

@Serializable
data class BookCollection(
  val total: Long,
  val bookList: List<Book>,
)

@Serializable
data class Book(
  val title: String,
  val subtitle: String,
  val isbn13: String,
  val price: String,
  val image: String,
  val url: String,
)
