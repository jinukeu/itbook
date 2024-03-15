package com.jinukeu.feature.bookdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.jinukeu.core.designsystem.component.LoadingScreen
import com.jinukeu.core.designsystem.theme.ItbookTheme
import com.jinukeu.core.ui.extension.collectWithLifecycle

@Composable
fun BookDetailRoute(
  viewModel: BookDetailViewModel = hiltViewModel(),
  onShowErrorSnackBar: (throwable: Throwable?, retry: (() -> Unit)?) -> Unit,
) {
  val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

  viewModel.sideEffect.collectWithLifecycle { sideEffect ->
    when (sideEffect) {
      is BookDetailSideEffect.ShowErrorSnackBar -> onShowErrorSnackBar(sideEffect.throwable, sideEffect.retry)
    }
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
  val bookDetail = uiState.bookDetail
  Surface {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
    ) {
      AsyncImage(
        modifier = Modifier
          .fillMaxWidth()
          .aspectRatio(1f),
        model = bookDetail.image,
        contentDescription = "Book Image",
      )

      with(bookDetail) {
        BookDetailInfoContainer(
          title = "title / authors",
          text = "$title / $authors",
        )

        BookDetailInfoContainer(
          title = "subtitle / publisher",
          text = "$subtitle / $publisher",
        )

        BookDetailInfoContainer(
          title = "isbn10 / isbn13",
          text = "$isbn10 / $isbn13",
        )

        BookDetailInfoContainer(
          title = "pages / year / rating",
          text = "$pages / $year / $rating",
        )

        BookDetailInfoContainer(
          title = "description",
          text = description,
        )

        BookDetailInfoContainer(
          title = "price",
          text = price,
        )

        BookDetailInfoContainer(
          title = "url",
          text = url,
        )

        pdf.forEach { (name, pdfUrl) ->
          BookDetailInfoContainer(
            title = name,
            text = pdfUrl,
          )
        }
      }
    }

    if (uiState.showLoadingScreen) {
      LoadingScreen()
    }
  }
}

@Composable
fun BookDetailInfoContainer(
  modifier: Modifier = Modifier,
  title: String,
  text: String,
) {
  Column(
    modifier = modifier
      .background(Color.White)
      .fillMaxWidth()
      .border(width = 1.dp, color = Color.Black)
      .padding(10.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp),
  ) {
    Text(text = title)
    Text(text = text, color = Color.Gray)
  }
}

@Preview(showBackground = true)
@Composable
fun BookDetailScreenPreview() {
  ItbookTheme {
    BookDetailScreen()
  }
}
