package com.example.deliveryfood.ui.profile.models


import com.google.gson.annotations.SerializedName

data class DefaultAddress(
    @SerializedName("address")
    val address: String,
    @SerializedName("house")
    val house: Any,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("tag")
    val tag: Any
)