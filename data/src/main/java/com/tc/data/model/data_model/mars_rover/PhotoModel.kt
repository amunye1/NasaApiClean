package com.tc.data.model.data_model.mars_rover


import com.google.gson.annotations.SerializedName

data class PhotoModel(
    @SerializedName("camera")
    val camera: CameraModel? = CameraModel(),
    @SerializedName("earth_date")
    val earthDate: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("img_src")
    val imgSrc: String? = "",
    @SerializedName("rover")
    val rover: RoverModel? = RoverModel(),
    @SerializedName("sol")
    val sol: Int? = 0
)