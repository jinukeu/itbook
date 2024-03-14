package com.jinukeu.feature.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jinukeu.core.designsystem.theme.ItbookTheme

/**
 * 내부에 존재하는 각각의 Text Component는 향후 개별적으로 다른 디자인이 적용될 가능성이 큽니다.
 * 따라서 공통 컴포넌트로 만들지 않았습니다.
 * */
@Composable
fun BookCardListType() {
  Row(
    modifier = Modifier
      .height(80.dp)
      .border(width = 1.dp, color = Color.Gray)
      .padding(8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    AsyncImage(
      modifier = Modifier
        .size(60.dp),
      model = "",
      contentDescription = null,
    )

    Column(
      modifier = Modifier
        .fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween,
    ) {
      Text(
        text = "TitleTitleTitleTitleTitleTitleTitleTitleTitleTitle",
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
      ) {
        Text(
          modifier = Modifier.weight(1f, fill = false),
          text = "SubTitleSubTitleSubTitleSubTitleSubTitleSubTitleSubTitleSubTitle",
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
        )
        Text(
          modifier = Modifier.weight(1f, fill = false),
          text = "pricepricepricepricepricepriceprice",
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
        )
      }
    }
  }
}

/**
 * 내부에 존재하는 각각의 Text Component는 향후 개별적으로 다른 디자인이 적용될 가능성이 큽니다.
 * 따라서 공통 컴포넌트로 만들지 않았습니다.
 * */
@Composable
fun BookCardGridType() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .border(width = 1.dp, color = Color.Gray)
      .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    AsyncImage(
      modifier = Modifier
        .size(60.dp),
      model = "",
      contentDescription = null,
    )

    Text(
      text = "TitleTitleTitleTitleTitleTitleTitleTitleTitleTitle",
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )

    Text(
      text = "SubTitleSubTitleSubTitleSubTitleSubTitleSubTitleSubTitleSubTitle",
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )

    Text(
      text = "pricepricepricepricepricepriceprice",
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )
  }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
  ItbookTheme {
    Column(
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      BookCardGridType()

      BookCardListType()
    }
  }
}
