package com.example.deliveryfood.data.network

import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.data.models.UserLocation
import com.example.deliveryfood.data.models.expandable.CurrentLocation
import retrofit2.Response
import retrofit2.http.*

interface ApiInterFace {
    @Headers("Content-Type: application/json")
    @GET("/api/restaurants")
    suspend fun getRestaurant(
        //  @Query("price") price:Int,
        //  @Query("name") name: String,
        //  @Query("address") address: String
        // @Query("state") state: String,
        @Query("city") city: String,
        //  @Query("zip") zip: String,
        @Query("country") country: String
        //   @Query("page") page: String,
        //  @Query("per_page") per_page: String
    ): Response<DataRestaurant>

    @GET("")
    suspend fun getDetailRestaurant(): Response<DataRestaurant>

    @GET("")
    suspend fun getSearchRestaurant(): Response<DataRestaurant>


    @POST("https://foodapi.achilov.dev/api/get-delivery-restaurants")
    suspend fun postLocation(@Body userLocation: UserLocation): Response<CurrentLocation>

}