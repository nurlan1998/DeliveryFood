package com.example.deliveryfood.ui.profile.models


import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("data")
    val data: LogInData,
    @SerializedName("success")
    val success: Boolean
)