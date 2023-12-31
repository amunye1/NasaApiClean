package com.tc.data.model.data_model.Apod


import com.google.gson.annotations.SerializedName

data class ApodItemModel(
    @SerializedName("copyright")
    val copyright: String? = "",
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("explanation")
    val explanation: String? = "",
    @SerializedName("hdurl")
    val hdurl: String? = "",
    @SerializedName("media_type")
    val mediaType: String? = "",
    @SerializedName("service_version")
    val serviceVersion: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("url")
    val url: String? = ""
)