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

class FilterClassTypeAdapter(private val searchItems: ArrayList<DummyData>) :
    RecyclerView.Adapter<FilterClassTypeAdapter.ViewHolder>() {

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_class_type, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.tvName.text = searchItems[position].message

        if (select == position){
            holder.imgCheckBox.setImageResource(R.drawable.ic_radio_select)
        }else{
            holder.imgCheckBox.setImageResource(R.drawable.ic_unselect_radio)
        }

        holder.itemView.setOnClickListener {
            select = position
            notifyDataSetChanged()
        }

    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.findViewById<TextView>(R.id.tvName)!!
        var imgCheckBox = itemView.findViewById<ImageView>(R.id.imgCheckBox)!!
    }
}