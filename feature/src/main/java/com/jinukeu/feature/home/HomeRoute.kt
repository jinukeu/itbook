package com.jinukeu.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jinukeu.core.designsystem.theme.ItbookTheme
import com.jinukeu.core.ui.extension.OnBottomReached
import com.jinukeu.core.ui.extension.collectWithLifecycle
import com.jinukeu.core.ui.extension.itbookClickable
import com.jinukeu.feature.R
import com.jinukeu.feature.home.component.BookCard
import com.jinukeu.feature.home.component.SearchBar

@Composable
fun HomeRoute(
  viewModel: HomeViewModel = hiltViewModel(),
  padding: PaddingValues,
) {
  val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

  val bookListState = rememberLazyGridState()

  viewModel.sideEffect.collectWithLifecycle { sideEffect ->
    // TODO
  }

  bookListState.OnBottomReached {
    viewModel.getBookList()
  }

  HomeScreen(
    uiState = uiState,
    padding = padding,
    bookListState = bookListState,
    onClickToggleBookListViewTypeButton = viewModel::toggleBookListViewType,
    onClickShowSearchBarButton = viewModel::showSearchBar,
    onValueChangeSearchKeyword = viewModel::updateSearchKeyword,
    onSearch = viewModel::searchBookList,
  )
}

@Composable
fun HomeScreen(
  uiState: HomeState = HomeState(),
  padding: PaddingValues = PaddingValues(0.dp),
  bookListState: LazyGridState = rememberLazyGridState(),
  onClickToggleBookListViewTypeButton: () -> Unit = {},
  onClickShowSearchBarButton: () -> Unit = {},
  onValueChangeSearchKeyword: (String) -> Unit = {},
  onSearch: (String) -> Unit = {},
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(padding)
      .padding(16.dp),
  ) {
    Row(
      modifier = Modifier.height(60.dp),
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Box(modifier = Modifier.weight(1f)) {
        if (uiState.showSearchBar) {
          SearchBar(
            value = uiState.searchKeyword,
            placeholder = "Search",
            onValueChange = onValueChangeSearchKeyword,
            onSearch = onSearch,
          )
        }
      }

      if (uiState.showSearchBarButton) {
        Image(
          modifier = Modifier
            .itbookClickable(onClick = onClickShowSearchBarButton)
            .padding(4.dp),
          painter = painterResource(id = R.drawable.ic_search),
          contentDescription = "Show SearchBar Icon",
        )
      }

      Image(
        modifier = Modifier
          .itbookClickable(onClick = onClickToggleBookListViewTypeButton)
          .padding(4.dp),
        painter = painterResource(id = uiState.toggleBookListViewTypeIconRes),
        contentDescription = "Toggle ViewType Icon",
      )
    }

    LazyVerticalGrid(
      modifier = Modifier.weight(1f),
      state = bookListState,
      contentPadding = PaddingValues(vertical = 16.dp),
      columns = GridCells.Fixed(uiState.homeBookListViewType.cellCount),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      items(
        items = uiState.bookList,
        key = { it.isbn13 },
      ) { book ->
        with(book) {
          BookCard(
            type = uiState.homeBookListViewType,
            imageUrl = image,
            title = title,
            subTitle = subtitle,
            price = price,
          )
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
  ItbookTheme {
    HomeScreen()
  }
}
