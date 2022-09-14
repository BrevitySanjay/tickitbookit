package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.moels.DummyData

class DestinationItemAdapter(private val searchItems : ArrayList<DummyData>) : RecyclerView.Adapter<DestinationItemAdapter.ViewHolder>(){


    private var select = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_destination, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvDescription.text = "$"+searchItems[position].message



    }

    override fun getItemCount() = searchItems.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)!!
        var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)!!
    }
}