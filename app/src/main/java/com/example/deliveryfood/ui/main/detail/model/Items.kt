package com.example.deliveryfood.ui.main.detail.model


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("Nonushta")
    val nonushta: List<Nonushta>,
    @SerializedName("Tushlik")
    val tushlik: List<Tushlik>
)