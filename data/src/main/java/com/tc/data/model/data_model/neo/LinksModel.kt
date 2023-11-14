package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class LinksModel(
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: String? = "",
    @SerializedName("self")
    val self: String? = ""
)