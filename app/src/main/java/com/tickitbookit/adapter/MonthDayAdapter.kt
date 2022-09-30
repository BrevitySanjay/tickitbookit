package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.activity.ActivityDetailsActivity
import com.tickitbookit.moels.DummyData

class MonthDayAdapter(private val searchItems : ArrayList<DummyData>) : RecyclerView.Adapter<MonthDayAdapter.ViewHolder>(){

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_day_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        if (select == position){
            holder.mainLayout.setBackgroundResource(R.drawable.select_line)
        }else{
            holder.mainLayout.setBackgroundResource(R.drawable.select_line_white)
        }

        holder.tvFlightPrice.text = "$"+searchItems[position].message
        holder.itemView.setOnClickListener {
            select = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvFlightPrice = itemView.findViewById<TextView>(R.id.tvFlightPrice)!!
        var mainLayout = itemView.findViewById<CardView>(R.id.mainLayout)!!
    }
}