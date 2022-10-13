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

class CardDetailsAdapter(private val searchItems: ArrayList<DummyData>) :
    RecyclerView.Adapter<CardDetailsAdapter.ViewHolder>() {

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_card_details, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.tvCardNum.text = searchItems[position].message

        if (position == select) {
            holder.imgCardSelecter.setImageResource(R.drawable.ic_purple_selected)
        } else {
            holder.imgCardSelecter.setImageResource(R.drawable.ic_purple_deselected)
        }

        holder.imgCardSelecter.setOnClickListener {
            select = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCardNum = itemView.findViewById<TextView>(R.id.tvCardNum)!!
        var imgCardSelecter = itemView.findViewById<ImageView>(R.id.imgCardSelecter)!!
    }
}