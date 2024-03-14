package com.jinukeu.domain.repository

import com.jinukeu.core.model.BookCollection
import com.jinukeu.core.model.BookDetail

interface BookRepository {

  suspend fun searchBookList(
    query: String = "",
    page: Int = 1,
  ): BookCollection

  suspend fun getBookDetail(
    isbn13: String,
  ): BookDetail
}
