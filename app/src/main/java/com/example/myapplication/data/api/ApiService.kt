package com.example.myapplication.data.api

import com.example.myapplication.model.CovidRecord
import retrofit2.http.GET

interface ApiService {

    @GET("v2/key-value-stores/tVaYRsPHLjNdNBu7S/records/LATEST")
    suspend fun getCovidRecords(): List<CovidRecord>
}