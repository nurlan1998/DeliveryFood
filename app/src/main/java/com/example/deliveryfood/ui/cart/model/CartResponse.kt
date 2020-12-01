package com.example.deliveryfood.ui.cart.model


import com.google.gson.annotations.SerializedName

data class CartResponse(
    @SerializedName("items")
    val items: List<CartData>
)