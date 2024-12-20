package com.yanic.api.network

import com.yanic.api.model.Cards
import retrofit2.http.GET

interface ApiService {

    @GET("/test/home")
    suspend fun getCards(): Cards

}