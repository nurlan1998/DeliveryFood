package com.example.deliveryfood.ui.menu.model


import com.google.gson.annotations.SerializedName

data class NewsPaperMenu(
    @SerializedName("foods")
    val headlines: List<HeadlinesMenu>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,

    var isExpanded: Boolean? = true
)