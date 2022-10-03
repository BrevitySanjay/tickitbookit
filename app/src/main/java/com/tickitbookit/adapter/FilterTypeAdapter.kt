package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.activity.ActivityDetailsActivity
import com.tickitbookit.hide
import com.tickitbookit.moels.DummyData
import com.tickitbookit.show

class FilterTypeAdapter(private val searchItems: ArrayList<DummyData>) :
    RecyclerView.Adapter<FilterTypeAdapter.ViewHolder>() {

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_filter_type, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.tvName.text = searchItems[position].message

        holder.itemView.setOnClickListener {

        }

    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.findViewById<TextView>(R.id.tvName)!!
    }
}