package com.yanic.api.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName


data class Cards(val page: Page)
data class Page(val cards: List<Card>)

@Entity
data class Card(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("card_type")
    val cardType: String?,
    @TypeConverters(CardDetailsTypeConverter::class)
    val card: CardDetails?
)

data class CardDetails(
    val title: Title? = null,
    val description: Description? = null,
    val image: Image? = null,
    val attributes: Attributes? = null,
    val value: String? = null
)

data class Title(val value: String, val attributes: Attributes)
data class Description(val value: String, val attributes: Attributes)
data class Image(val url: String?, val size: ImageSize? = null)
data class ImageSize(val width: Int, val height: Int)
data class Attributes(
    @SerializedName("text_color")
    val textColor: String?,
    val font: Font
)
data class Font(val size: Int?)