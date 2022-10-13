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

class NoOfTravellerAdapter(private val searchItems: ArrayList<DummyData>) :
    RecyclerView.Adapter<NoOfTravellerAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: OnItemClickListener
    private var select = -1

    private var noOfAdultPerSion = 0
    private var noOfChildrenPerSion = 0
    private var noOfInfantsPerSion = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.row_no_of_travellers, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.tvInfo.text = searchItems[position].message
        holder.tvHeading.text = searchItems[position].status

        holder.imgPlus3.setOnClickListener {
            when (position) {
                0 -> {
                    if (noOfAdultPerSion >= 0) {
                        noOfAdultPerSion = (noOfAdultPerSion + 1)
                        mItemClickListener.onClickPlus(
                            position,
                            holder.tvInfantsNum,
                            "Adult",
                            noOfAdultPerSion
                        )
                    }

                }
                1 -> {
                    if (noOfChildrenPerSion >= 0) {
                        noOfChildrenPerSion = (noOfChildrenPerSion + 1)
                        mItemClickListener.onClickPlus(
                            position,
                            holder.tvInfantsNum,
                            "Children",
                            noOfChildrenPerSion
                        )
                    }
                }
                2 -> {
                    if (noOfAdultPerSion >= 0) {
                        noOfInfantsPerSion = (noOfInfantsPerSion + 1)
                        mItemClickListener.onClickPlus(
                            position,
                            holder.tvInfantsNum,
                            "Infants",
                            noOfInfantsPerSion
                        )
                    }
                }
            }
        }

        holder.imgMinus3.setOnClickListener {
            when (position) {

                0 -> {
                    if (noOfAdultPerSion > 0) {
                        noOfAdultPerSion = (noOfAdultPerSion - 1)
                        mItemClickListener.onClickMinus(
                            position,
                            holder.tvInfantsNum,
                            "Adult",
                            noOfAdultPerSion
                        )
                    }
                }
                1 -> {
                    if (noOfChildrenPerSion > 0) {
                        noOfChildrenPerSion = (noOfChildrenPerSion - 1)
                        mItemClickListener.onClickMinus(
                            position,
                            holder.tvInfantsNum,
                            "Children",
                            noOfChildrenPerSion
                        )
                    }
                }
                2 -> {
                    if (noOfInfantsPerSion > 0) {
                        noOfInfantsPerSion = (noOfInfantsPerSion - 1)
                        mItemClickListener.onClickMinus(
                            position,
                            holder.tvInfantsNum,
                            "Infants",
                            noOfInfantsPerSion
                        )
                    }
                }
            }
        }
    }

    override fun getItemCount() = searchItems.size

    interface OnItemClickListener {
        fun onClickMinus(position: Int, tvMinus: TextView, type: String, noOfPerson: Int)
        fun onClickPlus(position: Int, tvPlus: TextView, type: String, person: Int)
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.mItemClickListener = mItemClickListener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvInfo = itemView.findViewById<TextView>(R.id.tvInfo)!!
        var tvHeading = itemView.findViewById<TextView>(R.id.tvHeading)!!
        var imgMinus3 = itemView.findViewById<ImageView>(R.id.imgMinus3)!!
        var imgPlus3 = itemView.findViewById<ImageView>(R.id.imgPlus3)!!
        var tvInfantsNum = itemView.findViewById<TextView>(R.id.tvInfantsNum)!!
    }


}