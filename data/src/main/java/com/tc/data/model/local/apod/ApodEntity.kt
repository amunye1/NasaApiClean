package com.tc.data.model.local.apod

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ApodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val copyright: String? = "",
    val date: String? = "",
    val explanation: String? = "",
    val hdurl: String? = "",
    val mediaType: String? = "",
    val serviceVersion: String? = "",
    val title: String? = "",
    val url: String? = ""
)
