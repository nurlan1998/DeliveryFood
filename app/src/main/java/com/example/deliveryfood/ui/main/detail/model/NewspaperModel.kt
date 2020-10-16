package com.example.deliveryfood.ui.main.detail.model

import com.example.deliveryfood.ui.main.detail.model.HeadlinesModel
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewspaperModel(

    @SerializedName("name")
    var papername:String? = null,
    @SerializedName("headlines")
    var paperHeadlinesModel: List<HeadlinesModel>? = null,
    @SerializedName("is_expanded")
    var isExpanded:Boolean? = false

):Serializable{
    override
    fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }

}
