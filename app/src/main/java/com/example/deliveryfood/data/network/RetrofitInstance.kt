package com.example.deliveryfood.data.network

import com.example.deliveryfood.other.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object {

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.readTimeout(60, TimeUnit.SECONDS)
            this.writeTimeout(60, TimeUnit.SECONDS)
            this.addInterceptor(interceptor)
        }.build()

        val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: ApiInterFace by lazy {
            retrofit.create(ApiInterFace::class.java)
        }
    }
}