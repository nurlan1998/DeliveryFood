package com.example.deliveryfood.repository

import android.location.Address
import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.data.network.RetrofitInstance
import retrofit2.Response

class Repository {

    suspend fun getRestaurant( price:Int, name:String,address:String): Response<DataRestaurant>{
        return RetrofitInstance.api.getRestaurant(price, name, address)
    }

    suspend fun getDetailRestaurant(): Response<DataRestaurant>{
        return RetrofitInstance.api.getDetailRestaurant()
    }

    suspend fun getSearchRestaurant(): Response<DataRestaurant>{
        return RetrofitInstance.api.getSearchRestaurant()
    }
}