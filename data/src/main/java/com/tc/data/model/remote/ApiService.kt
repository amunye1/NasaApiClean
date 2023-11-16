package com.tc.data.model.remote

import com.tc.data.model.data_model.Apod.ApodItemModel
import com.tc.data.model.data_model.mars_rover.MarsRoverItemModel
import com.tc.data.model.data_model.neo.NeoItemModel
import com.tc.data.model.remote.Constants.KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiDetails.APOD_ENDPOINT)
    suspend fun getApod(
        @Query("date") date :String ,
        @Query("api_key") apiKey: String = KEY
    ): ApodItemModel

    @GET(ApiDetails.MARS_ENDPOINT)
    suspend fun getMarsPhotos(
        @Query("sol") sol: Int = 10,
        @Query("api_key") apiKey: String = KEY
    ):MarsRoverItemModel
    @GET(ApiDetails.NEO_ENDPOINT)
    suspend fun getNeo(
        @Query("start_date") startDate :String ,
        @Query("end_date")  endDate :String ,
        @Query("api_key") apiKey: String = KEY
    ):NeoItemModel


}