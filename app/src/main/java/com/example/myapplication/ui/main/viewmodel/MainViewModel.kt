package com.example.myapplication.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.data.repository.MainRepository
import com.example.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers
import okhttp3.internal.wait


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    fun getCovidStats() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getCovidStats()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}