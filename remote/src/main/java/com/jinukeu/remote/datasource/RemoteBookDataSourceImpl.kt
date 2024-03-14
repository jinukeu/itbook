package com.jinukeu.remote.datasource

import com.jinukeu.core.model.BookCollection
import com.jinukeu.core.model.BookDetail
import com.jinukeu.data.datasource.RemoteBookDataSource
import com.jinukeu.remote.api.BookApi
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
  private val bookApi: BookApi,
) : RemoteBookDataSource {

  override suspend fun searchBookList(
    query: String,
    page: Int,
  ): BookCollection = bookApi.searchBookList(
    query = query,
    page = page,
  ).getOrThrow().toModel()

  override suspend fun getNewBookList(): BookCollection =
    bookApi
      .getNewBookList()
      .getOrThrow()
      .toModel()

  override suspend fun getBookDetail(isbn13: String): BookDetail =
    bookApi
      .getBookDetail(isbn13 = isbn13)
      .getOrThrow()
      .toModel()
}
