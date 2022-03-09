package com.example.myapplication.data.api

import com.example.myapplication.model.UsersData

interface ApiService {
    // TODO something is missing here :)
    suspend fun getUsers(): UsersData
}