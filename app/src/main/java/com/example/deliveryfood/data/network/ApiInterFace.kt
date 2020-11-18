package com.example.deliveryfood.data.network

import com.example.deliveryfood.data.models.Restaurants
import com.example.deliveryfood.ui.menu.model.RestourantsMenuTest
import retrofit2.Response
import retrofit2.http.*

interface ApiInterFace {

    @FormUrlEncoded
    @POST("/api/get-delivery-restaurants")
    suspend fun postLocation(
        @Field("latitude:") latitude: String,
        @Field("longitude:") longitude: String
    ): Response<Restaurants>

    @POST("/api/get-restaurant-items/{slug}")
    suspend fun restourantMenu(@Path(value = "slug") slug: String): Response<RestourantsMenuTest>

}