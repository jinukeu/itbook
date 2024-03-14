package com.jinukeu.remote.api

import com.jinukeu.core.network.retrofit.ApiResult
import com.jinukeu.remote.response.BookDetailResponse
import com.jinukeu.remote.response.BookListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApi {

  @GET("search/{query}/{page}")
  suspend fun searchBookList(
    @Path("query") query: String = "",
    @Path("page") page: Int = 1,
  ): ApiResult<BookListResponse>

  @GET("new")
  suspend fun getNewBookList(): ApiResult<BookListResponse>

  @GET("books/{isbn13}")
  suspend fun getBookDetail(
    @Path("isbn13") isbn13: String,
  ): ApiResult<BookDetailResponse>
}
