package com.yanic.api.test.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yanic.api.model.Attributes
import com.yanic.api.model.Card
import com.yanic.api.model.CardDetails
import com.yanic.api.model.Description
import com.yanic.api.model.Font
import com.yanic.api.model.Title

@Composable
fun TitleDescriptionCard(detail: CardDetails?) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Title
        Text(
            text = detail?.title?.value ?: "",
            color = Color(android.graphics.Color.parseColor(detail?.title?.attributes?.textColor)),
            fontSize = detail?.title?.attributes?.font?.size?.sp ?: 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
        // Description
        Text(
            text = detail?.description?.value ?: "",
            color = Color(android.graphics.Color.parseColor(detail?.description?.attributes?.textColor)),
            fontSize = detail?.description?.attributes?.font?.size?.sp ?: 16.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TitleDescriptionCardPreview() {
    val detail = CardDetails(
        title = Title(
            value = "title text",
            attributes = Attributes(textColor = "#000000", Font(30))
        ),
        description = Description(
            value = "description text",
            attributes = Attributes(textColor = "#000000", Font(22))
        )
    )

    val card = Card(id = 1, cardType = "title_description", card = detail)
    CardItem(card)
}

