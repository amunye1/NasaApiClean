package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class X19960225Model(
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitudeH: Double? = 0.0,
    @SerializedName("close_approach_data")
    val closeApproachData: List<CloseApproachDataModel>? = listOf(),
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameterModel? = EstimatedDiameterModel(),
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean? = false,
    @SerializedName("is_sentry_object")
    val isSentryObject: Boolean? = false,
    @SerializedName("links")
    val links: LinksModelX? = LinksModelX(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("nasa_jpl_url")
    val nasaJplUrl: String? = "",
    @SerializedName("neo_reference_id")
    val neoReferenceId: String? = ""
)