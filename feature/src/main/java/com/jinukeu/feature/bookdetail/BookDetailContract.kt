package com.jinukeu.feature.bookdetail

import com.jinukeu.core.model.BookDetail
import com.jinukeu.core.ui.base.SideEffect
import com.jinukeu.core.ui.base.UiState

data class BookDetailState(
  val bookDetail: BookDetail = BookDetail(),
) : UiState

sealed interface BookDetailSideEffect : SideEffect
