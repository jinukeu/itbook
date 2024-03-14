package com.jinukeu.data.datasource

import com.jinukeu.core.model.BookCollection
import com.jinukeu.core.model.BookDetail

interface RemoteBookDataSource {

  suspend fun searchBookList(
    query: String = "",
    page: Int = 1,
  ): BookCollection

  suspend fun getNewBookList(): BookCollection

  suspend fun getBookDetail(
    isbn13: String,
  ): BookDetail
}
