package com.tickitbookit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.tickitbookit.R
import com.tickitbookit.adapter.CardDetailsAdapter
import com.tickitbookit.adapter.DestinationItemAdapter
import com.tickitbookit.adapter.NearByAdapter
import com.tickitbookit.classes.CustomAppCompatActivity
import com.tickitbookit.databinding.ActivityAddNewCardBinding
import com.tickitbookit.databinding.ActivityCardDetailsBinding
import com.tickitbookit.moels.DummyData
import com.tickitbookit.utils.TAG

class AddNewCardActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityAddNewCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgBack.setOnClickListener { finish() }

        binding.CTextView20.setOnClickListener {
            calenderDialog()
        }
    }
}