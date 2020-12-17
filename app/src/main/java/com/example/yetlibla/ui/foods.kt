package com.example.yetlibla.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yetlibla.Adapters.ImagesAdapter
import com.example.yetlibla.R
import kotlinx.android.synthetic.main.activity_foods.*
import kotlinx.android.synthetic.main.activity_homepage.*

class foods : AppCompatActivity() {
    var RestuarensName : String?=null
    private var rating = mutableListOf<String>()
    private var pics = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent = intent
        RestuarensName = intent.getStringExtra("restaurent")
        Toast.makeText(this,"hey    " + RestuarensName,Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_foods)
        /*
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }*/
            mamaschicken()

            listing.layoutManager = LinearLayoutManager(this)
            listing.adapter = ImagesAdapter(rating,pics)

    }
    private fun addtolist(ratinglist:String,picslist:Int){
        rating.add(ratinglist)
        pics.add((picslist))
    }
    private fun mamaschicken(){
        addtolist("5",R.drawable.c)
        addtolist("4",R.drawable.w)

    }
}