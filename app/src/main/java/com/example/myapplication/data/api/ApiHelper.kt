package com.example.myapplication.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getCovidRecords() = apiService.getCovidRecords()

}