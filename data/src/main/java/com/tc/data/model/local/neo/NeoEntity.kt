package com.tc.data.model.local.neo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "neo")
data class NeoEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val closeApproachDate: String? = "",
    val closeApproachDateFull: String? = "",

)
