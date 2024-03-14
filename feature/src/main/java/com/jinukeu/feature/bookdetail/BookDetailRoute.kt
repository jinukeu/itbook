package com.jinukeu.feature.bookdetail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jinukeu.core.designsystem.theme.ItbookTheme
import com.jinukeu.core.ui.extension.collectWithLifecycle

@Composable
fun BookDetailRoute(
  viewModel: BookDetailViewModel = hiltViewModel(),
  popBackStack: () -> Unit,
) {
  val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

  viewModel.sideEffect.collectWithLifecycle { sideEffect ->
    // TODO
  }

  LaunchedEffect(key1 = Unit) {
    viewModel.initData()
  }

  BookDetailScreen(
    uiState = uiState,
  )
}

@Composable
fun BookDetailScreen(
  uiState: BookDetailState = BookDetailState(),
) {
}

@Preview(showBackground = true)
@Composable
fun BookDetailScreenPreview() {
  ItbookTheme {
    BookDetailScreen()
  }
}
