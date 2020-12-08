package com.example.deliveryfood.ui.nearme.models


import com.google.gson.annotations.SerializedName

data class PromoSlider(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_active")
    val isActive: Int,
    @SerializedName("location_id")
    val locationId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("position_id")
    val positionId: Int,
    @SerializedName("size")
    val size: Int,
    @SerializedName("updated_at")
    val updatedAt: String
)