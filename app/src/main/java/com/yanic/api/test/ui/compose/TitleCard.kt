package com.yanic.api.test.ui.compose

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
import com.yanic.api.model.Font

@Composable
fun TitleCard(detail: CardDetails?) {
    // Title
    Text(
        text = detail?.value ?: "",
        color = Color(android.graphics.Color.parseColor(detail?.attributes?.textColor)),
        fontSize = detail?.attributes?.font?.size?.sp ?: 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun TitleCardPreview() {
    val detail = CardDetails(
        value = "Value text", attributes = Attributes(textColor = "#000000", Font(30))
    )
    val card = Card(id = 1, cardType = "text", card = detail)
    CardItem(card)
}
