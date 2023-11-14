package com.tc.data.model.data_model.mars_rover


import com.google.gson.annotations.SerializedName

data class CameraModel(
    @SerializedName("full_name")
    val fullName: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("rover_id")
    val roverId: Int? = 0
)