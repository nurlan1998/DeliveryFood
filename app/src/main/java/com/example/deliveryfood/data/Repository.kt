package com.example.deliveryfood.data

import com.example.deliveryfood.data.models.Restaurants
import com.example.deliveryfood.data.network.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getCurrentLocationRes(latitude: String,longitude: String): Response<Restaurants>{
        return RetrofitInstance.api.postLocation(latitude, longitude)
    }
}