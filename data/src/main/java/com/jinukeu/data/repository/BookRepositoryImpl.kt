package com.jinukeu.data.repository

import com.jinukeu.core.model.BookCollection
import com.jinukeu.core.model.BookDetail
import com.jinukeu.data.datasource.RemoteBookDataSource
import com.jinukeu.domain.repository.BookRepository
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
  private val remoteBookDataSource: RemoteBookDataSource,
) : BookRepository {

  override suspend fun searchBookList(
    query: String,
    page: Int,
  ): BookCollection = with(remoteBookDataSource) {
    if (query.isEmpty()) {
      return@with getNewBookList()
    }

    remoteBookDataSource.searchBookList(
      query = query,
      page = page,
    )
  }

  override suspend fun getBookDetail(
    isbn13: String,
  ): BookDetail = remoteBookDataSource.getBookDetail(
    isbn13 = isbn13,
  )
}
