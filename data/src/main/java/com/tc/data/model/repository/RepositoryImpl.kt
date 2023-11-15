package com.tc.data.model.repository

import com.tc.data.model.data_model.Apod.ApodItemModel
import com.tc.data.model.data_model.mars_rover.MarsRoverItemModel
import com.tc.data.model.data_model.neo.NeoItemModel
import com.tc.data.model.remote.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val apiRequest: ApiService):Repository {

    override suspend fun getApod(startDate:String , endDate:String): List<ApodItemModel>{
        return apiRequest.getApod(startDate,endDate)
    }
    override suspend fun getMarsPhoto(): MarsRoverItemModel{
       return apiRequest.getMarsPhotos()
    }
    override suspend fun getNeo(startDate:String , endDate:String): NeoItemModel{
        return apiRequest.getNeo(startDate,endDate)
    }
}