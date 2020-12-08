package com.example.deliveryfood.data.network

import com.example.deliveryfood.ui.detail.models.DetailResponse
import com.example.deliveryfood.ui.nearme.models.RestaurantData
import com.example.deliveryfood.ui.cart.model.CartResponse
import com.example.deliveryfood.ui.menu.model.MenuResponse
import com.example.deliveryfood.ui.nearme.models.SliderResponse
import com.example.deliveryfood.ui.profile.models.LogInResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiInterFace {

    @FormUrlEncoded
    @POST("/api/get-delivery-restaurants")
    suspend fun postLocation(
        @Field("latitude:") latitude: String,
        @Field("longitude:") longitude: String
    ): Response<RestaurantData>

    @POST("/api/promo-slider")
    suspend fun getSliderData(): Response<SliderResponse>

    @POST("/api/get-restaurant-items/{id}")
    suspend fun restaurantMenu(@Path(value = "id") id:Int): Response<MenuResponse>

    @POST("/api/get-restaurant-info-by-id/{restaurant-id}")
    suspend fun restaurantDetailById(@Path(value = "restaurant-id") restaurantId: Int): Response<DetailResponse>

    @POST("/api/check-cart-items-availability")
    suspend fun getCartCheck(): Response<CartResponse>

    @FormUrlEncoded
    @Headers("Accept: application/json")
    @POST("/api/login")
    suspend fun logIn(
        @Field("name:") name: String,
        @Field("email:") email: String,
        @Field("password:") password: String,
        @Field("accessToken:") accessToken: String,
        @Field("phone:") phone: String,
        @Field("provider:") provider: String
    ): Response<LogInResponse>

}