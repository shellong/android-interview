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
        val factory = ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    private fun setupUI() {
        adapter = MainAdapter(arrayListOf());

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = adapter
            it.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    (recyclerView.layoutManager as LinearLayoutManager).orientation
                )
            )
        }

        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupObservers() {
        viewModel.getCovidStats().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { it -> retrieveList(it) }
                    }
                    Status.ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun retrieveList(covidRecords: List<CovidRecord>) {
        adapter.apply {
            addUsers(covidRecords)
            notifyDataSetChanged()
        }
    }
}