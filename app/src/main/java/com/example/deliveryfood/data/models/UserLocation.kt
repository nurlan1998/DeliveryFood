package com.example.deliveryfood.data.models

import com.google.gson.annotations.SerializedName

data class UserLocation(
    @SerializedName("latitude") val latitude: Double?,
    @SerializedName("longitude") val longitude: Double?
)