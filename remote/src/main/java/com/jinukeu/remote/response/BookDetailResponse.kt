package com.jinukeu.remote.response

import com.jinukeu.core.model.BookDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookDetailResponse(
  val title: String,
  val subtitle: String,
  val authors: String,
  val publisher: String,
  val isbn10: String,
  val isbn13: String,
  val pages: String,
  val year: String,
  val rating: String,
  @SerialName("desc") val description: String,
  val price: String,
  val image: String,
  val url: String,
  val pdf: Map<String, String> = mapOf(),
) {
  fun toModel() = BookDetail(
    title = title,
    subtitle = subtitle,
    authors = authors,
    publisher = publisher,
    isbn10 = isbn10,
    isbn13 = isbn13,
    pages = pages,
    year = year,
    rating = rating,
    description = description,
    price = price,
    image = image,
    url = url,
    pdf = pdf,
  )
}
