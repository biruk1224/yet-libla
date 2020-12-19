package com.example.yetlibla.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.yetlibla.R
import kotlinx.android.synthetic.main.activity_single.*

class Single : AppCompatActivity() {

    var RestuarensName : String?=null
    var lat :Double?=8.964154
    var lng :Double?=38.7781442
    var position : Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)
        var intent = intent
        RestuarensName = intent.getStringExtra("name")
        position=intent.getIntExtra("position",0)
        if("restaurants" == "restaurants"){
            lat =8.9641548
            lng = 38.7781442
        }
        location.setOnClickListener {
            val intent = Intent(this,Location::class.java)
            intent.putExtra("lat",lat)
            intent.putExtra("lng",lng)
            startActivity(intent)

        }




    }


}