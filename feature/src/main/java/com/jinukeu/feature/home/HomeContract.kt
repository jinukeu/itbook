package com.jinukeu.feature.home

import androidx.annotation.DrawableRes
import com.jinukeu.core.model.Book
import com.jinukeu.core.ui.base.SideEffect
import com.jinukeu.core.ui.base.UiState
import com.jinukeu.feature.R
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class HomeState(
  val showSearchBar: Boolean = false,
  val homeBookListViewType: HomeBookListViewType = HomeBookListViewType.LIST,
  val searchKeyword: String = "",
  val bookList: PersistentList<Book> = persistentListOf(),
) : UiState {
  @DrawableRes
  val toggleBookListViewTypeIconRes = when (homeBookListViewType) {
    HomeBookListViewType.LIST -> R.drawable.ic_list
    HomeBookListViewType.GRID -> R.drawable.ic_grid
  }

  val showSearchBarButton: Boolean = !showSearchBar
}

enum class HomeBookListViewType(val cellCount: Int) {
  LIST(1), GRID(3)
}

sealed interface HomeSideEffect : SideEffect {
  data class NavigateBookDetail(val isbn13: String) : HomeSideEffect
}
