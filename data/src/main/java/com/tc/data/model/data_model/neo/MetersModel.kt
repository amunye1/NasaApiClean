package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class MetersModel(
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double? = 0.0,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double? = 0.0
)