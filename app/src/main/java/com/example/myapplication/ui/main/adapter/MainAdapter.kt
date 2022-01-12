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
            itemView.apply {
                findViewById<TextView>(R.id.textViewCountryName).text = covidRecord.country
                findViewById<TextView>(R.id.textViewInfected).text = "Infected: ${covidRecord.infected}"
                findViewById<TextView>(R.id.textViewDeceased).text = "Deceased: ${covidRecord.deceased}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount(): Int = covidRecords.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(covidRecords[position])
    }

    fun addUsers(covidRecords: List<CovidRecord>) {
        this.covidRecords.apply {
            clear()
            addAll(covidRecords)
        }
    }
}