package com.example.myapplication.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.data.repository.MainRepository
import com.example.myapplication.model.UsersData
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    fun getUsers() = liveData<Resource<List<UsersData>>>(Dispatchers.IO) {
        TODO()
    }
}