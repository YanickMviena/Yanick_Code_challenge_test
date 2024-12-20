package com.yanic.api.test.ui.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import com.yanic.api.model.Card
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CardItem(item: Card) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        when (item.cardType) {
            "text" -> TitleCard(item.card)
            "title_description" -> TitleDescriptionCard(item.card)
            "image_title_description" -> TitleDescriptionImageCard(item.card)
        }
    }
}
