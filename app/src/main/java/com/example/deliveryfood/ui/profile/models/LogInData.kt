package com.example.deliveryfood.ui.profile.models


import com.google.gson.annotations.SerializedName

data class LogInData(
    @SerializedName("auth_token")
    val authToken: String,
    @SerializedName("default_address")
    val defaultAddress: DefaultAddress,
    @SerializedName("default_address_id")
    val defaultAddressId: Int,
    @SerializedName("delivery_pin")
    val deliveryPin: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: Any,
    @SerializedName("wallet_balance")
    val walletBalance: Int
)