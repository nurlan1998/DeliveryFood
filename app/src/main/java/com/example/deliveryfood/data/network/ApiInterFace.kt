package com.example.deliveryfood.data.network

import com.example.deliveryfood.data.models.DetailRestaurant
import com.example.deliveryfood.data.models.Restaurants
import com.example.deliveryfood.ui.cart.model.CartResponse
import com.example.deliveryfood.ui.menu.model.MenuResponse
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
    suspend fun restaurantMenu(@Path(value = "slug") slug: String): Response<MenuResponse>

    @POST("/api/get-restaurant-info-by-id/{restaurant-id}")
    suspend fun restaurantDetailById(@Path(value = "restaurant-id") restaurantId: Int): Response<DetailRestaurant>

    @POST("/api/check-cart-items-availability")
    suspend fun getCartCheck(): Response<CartResponse>

}