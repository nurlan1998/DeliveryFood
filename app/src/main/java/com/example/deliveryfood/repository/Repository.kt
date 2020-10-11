package com.example.deliveryfood.repository

import com.example.deliveryfood.data.models.DataRestaurant
import com.example.deliveryfood.data.network.RetrofitInstance
import retrofit2.Response

class Repository {

//    suspend fun getRestaurant(): Response<DataRestaurant>{
//       // return RetrofitInstance.api.getRestaurant()
//    }

    suspend fun getDetailRestaurant(): Response<DataRestaurant>{
        return RetrofitInstance.api.getDetailRestaurant()
    }

    suspend fun getSearchRestaurant(): Response<DataRestaurant>{
        return RetrofitInstance.api.getSearchRestaurant()
    }
}