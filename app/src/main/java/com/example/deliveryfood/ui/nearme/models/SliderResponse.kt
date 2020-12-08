package com.example.deliveryfood.ui.nearme.models


import com.google.gson.annotations.SerializedName

data class SliderResponse(
    @SerializedName("mainSlides")
    val mainSlides: List<MainSlide>,
    @SerializedName("otherSlides")
    val otherSlides: List<Any>
)