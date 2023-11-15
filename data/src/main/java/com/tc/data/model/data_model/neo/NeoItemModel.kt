package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class NeoItemModel(
    @SerializedName("element_count")
    val elementCount: Int? = 0,
    @SerializedName("links")
    val links: LinksModel? = LinksModel()
)