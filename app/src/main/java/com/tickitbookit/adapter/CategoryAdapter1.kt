package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.moels.DummyData


class CategoryAdapter1(private val categoryItem : ArrayList<DummyData>) : RecyclerView.Adapter<CategoryAdapter1.ViewHolder>(){

    var selected =-1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_catrgory1, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.tvCategoryName.text = categoryItem[position].message

        if (selected == position){
            holder.itemView.setBackgroundResource(R.drawable.round_corner_blue5_border)
            holder.tvCategoryName.setTextColor(Color.parseColor("#520086"))

        }else{
            holder.itemView.setBackgroundColor(0)
            holder.tvCategoryName.setTextColor(Color.parseColor("#53585A"))
            holder.itemView.setBackgroundResource(R.drawable.round_corner_gray5_border)
        }

        holder.itemView.setOnClickListener {
            selected = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = categoryItem.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCategoryName = itemView.findViewById<TextView>(R.id.tvCategoryName)!!
    }
}