package com.tickitbookit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.tickitbookit.R
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityAddTravellerBinding
import com.tickitbookit.hide
import com.tickitbookit.show

class AddTravellerActivity : CustomAppCompatActivity() {

    private lateinit var binding : ActivityAddTravellerBinding
    var adult = 0
    var children = 0

    var adultView = true
    var childrenView = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTravellerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addNewAdultView()

        addNewChildrenView()

        viewClick()

    }

    private fun viewClick(){

        binding.back.setOnClickListener { finish() }

        binding.tvAddNewAdult.setOnClickListener {
            addNewAdultView()
        }

        binding.tvAddNewChildren.setOnClickListener {
            addNewChildrenView()
        }

        binding.tvSelectType.setOnClickListener {
            adultView = if (adultView){
                binding.parentLinearLayout.hide()
                false
            }else{
                binding.parentLinearLayout.show()
                true
            }
        }

        binding.tvSelectChildren.setOnClickListener {
            childrenView = if (childrenView){
                binding.parentChildrenLinearLayout.hide()
                false
            }else{
                binding.parentChildrenLinearLayout.show()
                true
            }
        }
    }

    private fun addNewAdultView() {
        adult++
        binding.tvAdult.text = "Adult:$adult"
        binding.tvSelectType.text = "Adult X $adult"
        binding.parentLinearLayout.addView(LayoutInflater.from(this).inflate(R.layout.row_add_adult, null), binding.parentLinearLayout.childCount)
    }


    private fun addNewChildrenView() {
        children++
        binding.tvChildren.text = "Children:$children"
        binding.tvSelectChildren.text = "Children X $children"
        binding.parentChildrenLinearLayout.addView(LayoutInflater.from(this).inflate(R.layout.row_add_children, null), binding.parentChildrenLinearLayout.childCount)
    }

}