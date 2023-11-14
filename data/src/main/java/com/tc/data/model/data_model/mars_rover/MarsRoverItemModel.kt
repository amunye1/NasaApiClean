package com.tc.data.model.data_model.mars_rover


import com.google.gson.annotations.SerializedName

data class MarsRoverItemModel(
    @SerializedName("photos")
    val photos: List<PhotoModel>? = listOf()
)