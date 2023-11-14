package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class MissDistanceModel(
    @SerializedName("astronomical")
    val astronomical: String? = "",
    @SerializedName("kilometers")
    val kilometers: String? = "",
    @SerializedName("lunar")
    val lunar: String? = "",
    @SerializedName("miles")
    val miles: String? = ""
)