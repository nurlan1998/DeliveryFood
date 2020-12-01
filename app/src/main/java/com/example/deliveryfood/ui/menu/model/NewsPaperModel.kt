package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class NewsPaperModel(
    @SerializedName("foods")
    val headlines: List<HeadlinesModel>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,

    var isExpanded: Boolean? = true
)