package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class EstimatedDiameterModel(
    @SerializedName("feet")
    val feet: FeetModel? = FeetModel(),
    @SerializedName("kilometers")
    val kilometers: KilometersModel? = KilometersModel(),
    @SerializedName("meters")
    val meters: MetersModel? = MetersModel(),
    @SerializedName("miles")
    val miles: MilesModel? = MilesModel()
)