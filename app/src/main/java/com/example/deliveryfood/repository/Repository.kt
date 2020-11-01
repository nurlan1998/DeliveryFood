package com.example.deliveryfood.repository

import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.data.models.UserLocation
import com.example.deliveryfood.data.models.expandable.CurrentLocation
import com.example.deliveryfood.data.network.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getRestaurant(city: String, country: String): Response<DataRestaurant> {
        return RetrofitInstance.api.getRestaurant(city, country)
    }

    suspend fun getDetailRestaurant(): Response<DataRestaurant> {
        return RetrofitInstance.api.getDetailRestaurant()
    }

    suspend fun getSearchRestaurant(): Response<DataRestaurant> {
        return RetrofitInstance.api.getSearchRestaurant()
    }

    suspend fun getCurrentLocationRes(): Response<CurrentLocation>{
        return RetrofitInstance.api.postLocation( UserLocation(41.311081,69.240562))
    }
}