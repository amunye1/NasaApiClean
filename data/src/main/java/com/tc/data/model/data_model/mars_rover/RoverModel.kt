package com.tc.data.model.data_model.mars_rover


import com.google.gson.annotations.SerializedName

data class RoverModel(
    @SerializedName("cameras")
    val cameras: List<CameraModelX>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("landing_date")
    val landingDate: String? = "",
    @SerializedName("launch_date")
    val launchDate: String? = "",
    @SerializedName("max_date")
    val maxDate: String? = "",
    @SerializedName("max_sol")
    val maxSol: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("status")
    val status: String? = "",
    @SerializedName("total_photos")
    val totalPhotos: Int? = 0
)