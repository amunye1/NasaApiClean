package com.tc.data.model.local.mars

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tc.data.model.data_model.mars_rover.CameraModel
import com.tc.data.model.data_model.mars_rover.RoverModel

@Entity(tableName = "mars")
data class MarsEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val camera: CameraModel? = CameraModel(),
    val earthDate: String? = "",
    val imgSrc: String? = "",
    val rover: RoverModel? = RoverModel(),
    val sol: Int? = 0
)