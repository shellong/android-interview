package com.example.myapplication.data.api

import com.example.myapplication.model.CovidRecord

interface ApiService {
    // TODO something is missing here :)
    suspend fun getCovidRecords(): List<CovidRecord>
}