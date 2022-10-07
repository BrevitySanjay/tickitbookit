package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.activity.ActivityDetailsActivity
import com.tickitbookit.controls.CTextView
import com.tickitbookit.moels.DummyData
import com.tickitbookit.moels.DummyData_3

class PromoCodeAdapter(
    private val searchItems: ArrayList<DummyData>,
    private val tvPromoCode: CTextView
) :
    RecyclerView.Adapter<PromoCodeAdapter.ViewHolder>() {

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_promocode, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        Log.d("TAG", "onBindViewHolder: ")
        holder.tvPromoCode.text = searchItems[position].message
        holder.tvPromoCodeDesc.text = searchItems[position].message

        if (position == select) {
            holder.tvApplied.setText("Applied")
            tvPromoCode.setText(searchItems[position].message)
        } else {
            holder.tvApplied.setText("Apply")
        }

        holder.tvApplied.setOnClickListener {
            select = position
            notifyDataSetChanged()
        }

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(
                    holder.itemView.context,
                    ActivityDetailsActivity::class.java
                )
            )
        }
    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPromoCode = itemView.findViewById<TextView>(R.id.tvPromoCode)!!
        var tvApplied = itemView.findViewById<TextView>(R.id.tvApplied)!!
        var tvPromoCodeDesc = itemView.findViewById<TextView>(R.id.tvPromoCodeDesc)!!
    }
}