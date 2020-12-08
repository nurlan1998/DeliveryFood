package com.example.deliveryfood.data

import com.example.deliveryfood.data.network.RetrofitInstance
import com.example.deliveryfood.ui.profile.models.LogInResponse
import retrofit2.Response

class RepositoryAuthorization {

    suspend fun logIn(
        name: String,
        email: String,
        password: String,
        accessToken: String,
        phone: String,
        provider: String
    ): Response<LogInResponse> {
        return RetrofitInstance.api.logIn(name, email, password, accessToken, phone, provider)
    }
}