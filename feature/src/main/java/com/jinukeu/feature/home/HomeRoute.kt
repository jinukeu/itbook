package com.jinukeu.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinukeu.core.designsystem.theme.ItbookTheme

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
      .padding(padding),
  ) {
  }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
  ItbookTheme {
    HomeScreen()
  }
}
