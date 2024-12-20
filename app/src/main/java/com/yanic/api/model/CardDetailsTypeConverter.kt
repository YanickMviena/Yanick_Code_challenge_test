package com.yanic.api.model

import androidx.room.TypeConverter
import com.google.gson.Gson

class CardDetailsTypeConverter {

    @TypeConverter
    fun fromCardDetails(cardDetails: CardDetails?): String? {
        // Convert CardDetails to String (e.g., using Gson)
        return Gson().toJson(cardDetails)
    }

    @TypeConverter
    fun toCardDetails(cardDetailsString: String?): CardDetails? {
        // Convert String back to CardDetails (e.g., using Gson)
        return Gson().fromJson(cardDetailsString, CardDetails::class.java)
    }
}
