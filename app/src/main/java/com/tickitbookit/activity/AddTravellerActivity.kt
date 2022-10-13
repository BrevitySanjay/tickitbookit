package com.tickitbookit.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityAddTravellerBinding
import com.tickitbookit.hide
import com.tickitbookit.show


class AddTravellerActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityAddTravellerBinding
    var adult = 0
    var children = 0

    var adultView = true
    var childrenView = true
    var gstDetails = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTravellerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addNewAdultView()

        addNewChildrenView()

        viewClick()

        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

    }

    private fun viewClick() {

        binding.back.setOnClickListener { finish() }

        binding.tvAddNewAdult.setOnClickListener {
            addNewAdultView()
        }

        binding.tvAddNewChildren.setOnClickListener {
            addNewChildrenView()
        }

        binding.tvSelectType.setOnClickListener {
            adultView = if (adultView) {
                binding.parentLinearLayout.hide()
                false
            } else {
                binding.parentLinearLayout.show()
                true
            }
        }

        binding.tvSelectChildren.setOnClickListener {
            childrenView = if (childrenView) {
                binding.parentChildrenLinearLayout.hide()
                false
            } else {
                binding.parentChildrenLinearLayout.show()
                true
            }
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this@AddTravellerActivity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        binding.btnContinue.setOnClickListener {
            startActivity(Intent(this,TravellerDetailsActivity::class.java))
        }

        binding.imgRefund.setOnClickListener {
            gstDetails = if (gstDetails){
                binding.imgRefund.setImageResource(R.drawable.ic_refund_unselect)
                false
            }else{
                binding.imgRefund.setImageResource(R.drawable.ic_check)
                true
            }
        }
    }

    private fun addNewAdultView() {
        adult++
        binding.tvAdult.text = "Adult:$adult"
        binding.tvSelectType.text = "Adult X $adult"
        binding.parentLinearLayout.addView(
            LayoutInflater.from(this).inflate(R.layout.row_add_adult, null),
            binding.parentLinearLayout.childCount
        )
    }


    private fun addNewChildrenView() {
        children++
        binding.tvChildren.text = "Children:$children"
        binding.tvSelectChildren.text = "Children X $children"
        binding.parentChildrenLinearLayout.addView(
            LayoutInflater.from(this).inflate(R.layout.row_add_children, null),
            binding.parentChildrenLinearLayout.childCount
        )
    }

}