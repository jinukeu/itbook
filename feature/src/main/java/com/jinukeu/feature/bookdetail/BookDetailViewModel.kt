package com.jinukeu.feature.bookdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.jinukeu.core.ui.base.BaseViewModel
import com.jinukeu.domain.usecase.GetBookDetailUseCase
import com.jinukeu.feature.MainRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookDetailViewModel @Inject constructor(
  private val getBookDetailUseCase: GetBookDetailUseCase,
  savedStateHandle: SavedStateHandle,
) : BaseViewModel<BookDetailState, BookDetailSideEffect>(
  BookDetailState(),
) {
  private val isbn13 = savedStateHandle.get<String>(MainRoute.BOOK_DETAIL_ARGUMENT)!!

  fun initData() = viewModelScope.launch {
    intent { copy(showLoadingScreen = true) }
    getBookDetailUseCase(isbn13 = isbn13)
      .onSuccess { intent { copy(bookDetail = it) } }
      .onFailure { throwable ->
        postSideEffect(BookDetailSideEffect.ShowErrorSnackBar(throwable, ::initData))
      }
    intent { copy(showLoadingScreen = false) }
  }
}
