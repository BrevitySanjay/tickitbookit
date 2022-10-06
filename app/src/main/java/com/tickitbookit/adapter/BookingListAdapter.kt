package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.activity.ActivityDetailsActivity
import com.tickitbookit.moels.DummyData

class BookingListAdapter(private val searchItems : ArrayList<DummyData>) : RecyclerView.Adapter<BookingListAdapter.ViewHolder>(){

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_no_of_flight_bookign, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
       // holder.tvPrice.text = "$"+searchItems[position].message


    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)!!
    }
}