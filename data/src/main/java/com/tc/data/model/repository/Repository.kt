package com.tc.data.model.repository

import com.tc.data.model.data_model.Apod.ApodItemModel
import com.tc.data.model.data_model.mars_rover.MarsRoverItemModel
import com.tc.data.model.data_model.neo.NeoItemModel

interface Repository {
    suspend fun getApod(date:String):ApodItemModel
    suspend fun getMarsPhoto(): MarsRoverItemModel
    suspend fun getNeo(startDate:String , endDate:String):NeoItemModel
}