package com.jinukeu.remote.response

import com.jinukeu.core.model.Book
import com.jinukeu.core.model.BookCollection
import kotlinx.serialization.Serializable

@Serializable
data class BookListResponse(
  val total: String,
  val bookList: List<BookResponse>,
) {
  fun toModel() = BookCollection(
    total = total.toLongOrNull() ?: 0L,
    bookList = bookList.map { it.toModel() },
  )
}

@Serializable
data class BookResponse(
  val title: String,
  val subtitle: String,
  val isbn13: String,
  val price: String,
  val image: String,
  val url: String,
) {
  fun toModel() = Book(
    title = title,
    subtitle = subtitle,
    isbn13 = isbn13,
    price = price,
    image = image,
    url = url,
  )
}
