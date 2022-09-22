package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import android.widget.TextView
import com.tickitbookit.moels.DummyData


class SearchActivityDialogAdapter(private val searchItems1 : ArrayList<DummyData>) :
    RecyclerView.Adapter<SearchActivityDialogAdapter.ViewHolder>(){

    var selected =-1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).
    inflate(R.layout.row_search_activities, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.tvCategoryName.text = searchItems1[position].message


        holder.itemView.setOnClickListener {

        }

    }

    override fun getItemCount() = searchItems1.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCategoryName = itemView.findViewById<TextView>(R.id.tvCategoryName)!!
    }
}