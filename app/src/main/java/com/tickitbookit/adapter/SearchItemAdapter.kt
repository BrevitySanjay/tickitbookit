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

class SearchItemAdapter(private val searchItems : ArrayList<DummyData>) : RecyclerView.Adapter<SearchItemAdapter.ViewHolder>(){


    private var select = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_activity, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvPrice.text = "$"+searchItems[position].message

        if (position == select){
            holder.ivFavourite.setImageResource(R.drawable.ic_heart_selected)
        }else{
            holder.ivFavourite.setImageResource(R.drawable.ic_heart_unselect)
        }

        holder.ivFavourite.setOnClickListener {
            select = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = searchItems.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPrice = itemView.findViewById<TextView>(R.id.tvPrice)!!
        var ivFavourite = itemView.findViewById<ImageView>(R.id.ivFavourite)!!
    }
}