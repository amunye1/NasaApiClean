package com.tc.data.model.data_model.neo


import com.google.gson.annotations.SerializedName

data class CloseApproachDataModel(
    @SerializedName("close_approach_date")
    val closeApproachDate: String? = "",
    @SerializedName("close_approach_date_full")
    val closeApproachDateFull: String? = "",
    @SerializedName("epoch_date_close_approach")
    val epochDateCloseApproach: Long? = 0,
    @SerializedName("miss_distance")
    val missDistance: MissDistanceModel? = MissDistanceModel(),
    @SerializedName("orbiting_body")
    val orbitingBody: String? = "",
    @SerializedName("relative_velocity")
    val relativeVelocity: RelativeVelocityModel? = RelativeVelocityModel()
)