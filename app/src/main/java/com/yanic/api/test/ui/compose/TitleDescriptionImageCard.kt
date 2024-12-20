package com.yanic.api.test.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.yanic.api.model.CardDetails
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.tooling.preview.Preview
import com.yanic.api.model.Attributes
import com.yanic.api.model.Card
import com.yanic.api.model.Description
import com.yanic.api.model.Font
import com.yanic.api.model.Image
import com.yanic.api.model.Title

@Composable
fun TitleDescriptionImageCard(detail: CardDetails?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Background Image
        AsyncImage(
            model = detail?.image?.url,
            contentDescription = null,
            contentScale = ContentScale.Inside,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Title
            Text(
                text = detail?.title?.value ?: "",
                color = Color(android.graphics.Color.parseColor(detail?.title?.attributes?.textColor)),
                fontSize = detail?.title?.attributes?.font?.size?.sp ?: 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
            // Detail
            Text(
                text = detail?.description?.value ?: "",
                color = Color(android.graphics.Color.parseColor(detail?.description?.attributes?.textColor)),
                fontSize = detail?.description?.attributes?.font?.size?.sp ?: 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))

        }
    }

}

@Preview(showBackground = true)
@Composable
fun TitleDescriptionImageCardPreview() {
    val detail = CardDetails(
        title = Title(
            value = "title text",
            attributes = Attributes(textColor = "#000000", Font(30))
        ),
        description = Description(
            value = "description text",
            attributes = Attributes(textColor = "#FFFFFF", Font(22))
        ),
        image = Image(url = "https://qaevolution.blob.core.windows.net/assets/ios/3x/Featured@4.76x.png")
    )

    val card = Card(id = 1, cardType = "image_title_description", card = detail)
    CardItem(card)
}
