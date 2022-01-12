package com.example.myapplication.ui.main.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.api.ApiHelper
import com.example.myapplication.data.api.RetrofitBuilder
import com.example.myapplication.model.CovidRecord
import com.example.myapplication.ui.base.ViewModelFactory
import com.example.myapplication.ui.main.adapter.MainAdapter
import com.example.myapplication.ui.main.viewmodel.MainViewModel
import com.example.myapplication.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        TODO("Not yet implemented")
    }

    private fun setupUI() {
        TODO("Not yet implemented")
    }

    private fun setupObservers() {
        TODO("Not yet implemented")
    }
}