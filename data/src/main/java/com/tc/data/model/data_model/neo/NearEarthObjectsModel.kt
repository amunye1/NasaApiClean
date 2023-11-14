package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class NearEarthObjectsModel(
    @SerializedName("1996-02-25")
    val x19960225: List<X19960225Model>? = listOf(),
    @SerializedName("1996-02-26")
    val x19960226: List<X19960226Model>? = listOf(),
    @SerializedName("1996-02-27")
    val x19960227: List<X19960227Model>? = listOf(),
    @SerializedName("1996-02-28")
    val x19960228: List<X19960228Model>? = listOf(),
    @SerializedName("1996-02-29")
    val x19960229: List<X19960229Model>? = listOf(),
    @SerializedName("1996-03-01")
    val x19960301: List<X19960301Model>? = listOf()
)