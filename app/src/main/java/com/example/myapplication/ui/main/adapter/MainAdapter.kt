package com.example.myapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.CovidRecord

class MainAdapter(private val covidRecords: ArrayList<CovidRecord>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(covidRecord: CovidRecord) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))



    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setCovidRecords(covidRecords: List<CovidRecord>) {
        this.covidRecords.apply {
            clear()
            addAll(covidRecords)
        }
    }
}