package com.example.deliveryfood.data.models


import com.google.gson.annotations.SerializedName

data class SingleRestaurant(
    @SerializedName("address")
    val address: String,
    @SerializedName("area")
    val area: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("mobile_reserve_url")
    val mobileReserveUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("postal_code")
    val postalCode: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("reserve_url")
    val reserveUrl: String,
    @SerializedName("state")
    val state: String
)