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
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinukeu.core.designsystem.theme.ItbookTheme
import com.jinukeu.feature.R
import com.jinukeu.feature.home.component.BookCardGridType
import com.jinukeu.feature.home.component.SearchBar

@Composable
fun HomeRoute(
  padding: PaddingValues,
) {
  HomeScreen(
    padding = padding,
  )
}

@Composable
fun HomeScreen(
  padding: PaddingValues = PaddingValues(0.dp),
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
        SearchBar(
          value = "",
          placeholder = "Search",
        )
      }

      Image(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = "Show SearchBar Icon",
      )

      Image(
        painter = painterResource(id = R.drawable.ic_grid),
        contentDescription = "Change ViewType Icon",
      )
    }

    LazyVerticalGrid(
      contentPadding = PaddingValues(vertical = 16.dp),
      columns = GridCells.Fixed(3),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      item {
        BookCardGridType()
      }

      item {
        BookCardGridType()
      }

      item {
        BookCardGridType()
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
