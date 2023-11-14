package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class RelativeVelocityModel(
    @SerializedName("kilometers_per_hour")
    val kilometersPerHour: String? = "",
    @SerializedName("kilometers_per_second")
    val kilometersPerSecond: String? = "",
    @SerializedName("miles_per_hour")
    val milesPerHour: String? = ""
)