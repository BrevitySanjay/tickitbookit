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
import com.tickitbookit.databinding.ActivityCardDetailsBinding
import com.tickitbookit.moels.DummyData
import com.tickitbookit.utils.TAG

class CardDetailsActivity : CustomAppCompatActivity() {

    private lateinit var binding: ActivityCardDetailsBinding
    private val searchItems = ArrayList<DummyData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        searchItems.add(DummyData("350", "**** **** 350"))
        searchItems.add(DummyData("350", "**** **** 550"))
        searchItems.add(DummyData("350", "**** **** 632"))

        binding.rvCardDetails.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCardDetails.adapter = CardDetailsAdapter(searchItems)

        binding.tvAddCard.setOnClickListener {
            startActivity(Intent(this, AddNewCardActivity::class.java))
        }

        binding.imgBack.setOnClickListener { finish() }

    }
}