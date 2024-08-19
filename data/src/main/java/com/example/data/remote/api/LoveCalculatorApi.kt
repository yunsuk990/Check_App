package com.example.data.remote.api

import com.example.data.remote.model.DataLoveResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveCalculatorApi {

    @GET("get+match")
    suspend fun getPercentage(
        @Header("Authorization") key: String,
        @Query("fname") fName :String,
        @Query("sname") sName :String,
    ): Response<DataLoveResponse>

}