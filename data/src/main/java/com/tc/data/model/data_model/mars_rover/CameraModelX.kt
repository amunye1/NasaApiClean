package com.tc.data.model.data_model.mars_rover


import com.google.gson.annotations.SerializedName

data class CameraModelX(
    @SerializedName("full_name")
    val fullName: String? = "",
    @SerializedName("name")
    val name: String? = ""
)