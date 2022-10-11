package com.tickitbookit.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.tickitbookit.R
import com.tickitbookit.activity.ActivityDetailsActivity
import com.tickitbookit.activity.CancellationActivity
import com.tickitbookit.activity.TravellerDetailsActivity
import com.tickitbookit.moels.DummyData

class BookingListAdapter(private val searchItems : ArrayList<DummyData>) : RecyclerView.Adapter<BookingListAdapter.ViewHolder>(){

    private var select = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_no_of_flight_bookign, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.tvPolicy.setOnClickListener(){
            holder.itemView.context.startActivity(Intent(holder.itemView.context, CancellationActivity::class.java))
        }
    }

    override fun getItemCount() = searchItems.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvPolicy = itemView.findViewById<TextView>(R.id.tvPolicy)!!
    }
}