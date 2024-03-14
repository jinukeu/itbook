package com.jinukeu.feature

object MainRoute {
  const val homeRoute = "home"

  const val BOOK_DETAIL_ARGUMENT = "isbn13"
  fun bookDetailRoute(isbn13: String) = "book/detail/$isbn13"
}
