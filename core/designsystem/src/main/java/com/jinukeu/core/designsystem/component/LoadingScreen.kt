package com.jinukeu.core.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinukeu.core.designsystem.theme.ItbookTheme
import com.jinukeu.core.ui.extension.itbookClickable

@Composable
fun LoadingScreen(
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .itbookClickable(rippleEnabled = false, onClick = {}),
    contentAlignment = Alignment.Center,
  ) {
    CircularProgressIndicator(
      modifier = modifier.size(40.dp),
      color = Color.Black,
    )
  }
}

@Preview
@Composable
fun LoadingScreenPreview() {
  ItbookTheme {
    LoadingScreen()
  }
}
