package com.example.deliveryfood.ui.nearme.models


import com.google.gson.annotations.SerializedName

data class MainSlide(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("image_placeholder")
    val imagePlaceholder: Any,
    @SerializedName("is_active")
    val isActive: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order_column")
    val orderColumn: Int,
    @SerializedName("promo_slider")
    val promoSlider: PromoSlider,
    @SerializedName("promo_slider_id")
    val promoSliderId: Int,
    @SerializedName("unique_id")
    val uniqueId: Any,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
)