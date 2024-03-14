package com.jinukeu.feature.home

import androidx.lifecycle.viewModelScope
import com.jinukeu.core.model.Book
import com.jinukeu.core.model.BookCollection
import com.jinukeu.core.ui.base.BaseViewModel
import com.jinukeu.domain.usecase.SearchBookListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val searchBookListUseCase: SearchBookListUseCase,
) : BaseViewModel<HomeState, HomeSideEffect>(
  HomeState(),
) {
  private var query: String = ""
  private var page = FIRST_PAGE
  private var isLast = false
  fun searchBookList(query: String) {
    this.query = query

    getBookList(needClear = true)
  }

  fun refreshBookList(onFinish: () -> Unit = {}) = viewModelScope.launch {
    getBookList(true).join()
    onFinish()
  }

  fun getBookList(needClear: Boolean = false) = viewModelScope.launch {
    val currentList = if (needClear) {
      page = FIRST_PAGE
      isLast = false
      persistentListOf()
    } else {
      currentState.bookList
    }

    if (isLast) return@launch

    searchBookListUseCase(
      query = query,
      page = page,
    ).onSuccess { response ->
      handleHomeUnsplashPhotoSuccess(response, currentList)
    }
  }

  private fun handleHomeUnsplashPhotoSuccess(
    response: BookCollection,
    currentList: PersistentList<Book>,
  ) = intent {
    val newList = currentList
      .addAll(response.bookList)

    isLast = response.total <= newList.size
    page += 1

    copy(
      bookList = newList,
    )
  }

  fun updateSearchKeyword(searchKeyword: String) = intent {
    copy(searchKeyword = searchKeyword)
  }

  fun navigateBookDetail(isbn13: String) = postSideEffect(HomeSideEffect.NavigateBookDetail(isbn13))
  fun toggleBookListViewType() = intent {
    copy(
      homeBookListViewType = when (homeBookListViewType) {
        HomeBookListViewType.LIST -> HomeBookListViewType.GRID
        HomeBookListViewType.GRID -> HomeBookListViewType.LIST
      },
    )
  }

  fun showSearchBar() = intent {
    copy(
      showSearchBar = true,
    )
  }

  companion object {
    private const val FIRST_PAGE = 1
  }
}
