package com.jinukeu.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jinukeu.core.designsystem.theme.ItbookTheme
import com.jinukeu.feature.R

@Composable
fun SearchBar(
  modifier: Modifier = Modifier,
  value: String,
  onValueChange: (String) -> Unit = {},
  maxLines: Int = 1,
  minLines: Int = 1,
  interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
  placeholder: String,
  placeholderColor: Color = Color.Gray,
  keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
  keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
  onSearch: (String) -> Unit = {},
) {
  BasicTextField(
    value = value,
    onValueChange = onValueChange,
    modifier = modifier,
    singleLine = maxLines == 1,
    maxLines = if (minLines > maxLines) minLines else maxLines,
    minLines = minLines,
    interactionSource = interactionSource,
    keyboardOptions = keyboardOptions,
    keyboardActions = KeyboardActions(
      onSearch = {
        onSearch(value)
        keyboardController?.hide()
      },
    ),
    decorationBox = { innerText ->
      Row(
        modifier = Modifier
          .background(Color.LightGray)
          .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Image(
          painter = painterResource(id = R.drawable.ic_search),
          contentDescription = null,
        )

        Spacer(modifier = Modifier.width(12.dp))

        Box(
          modifier = Modifier.weight(1f),
          contentAlignment = Alignment.CenterStart,
        ) {
          innerText()
          if (value.isEmpty()) {
            Text(
              text = placeholder,
              color = placeholderColor,
            )
          }
        }
      }
    },
  )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
  ItbookTheme {
    var text by remember {
      mutableStateOf("")
    }

    SearchBar(
      value = text,
      onValueChange = { text = it },
      placeholder = "Search",
    )
  }
}
