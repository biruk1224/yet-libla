package com.example.yetlibla.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yetlibla.Adapters.ImagesAdapter
import com.example.yetlibla.R
import kotlinx.android.synthetic.main.activity_foods.*
import kotlinx.android.synthetic.main.activity_homepage.*

class foods : AppCompatActivity() {
    var restaurant: String?=null
    var position : Int?=null

    private var name = mutableListOf<String>()
    private var pics = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var intent = intent
        restaurant = intent.getStringExtra("restaurant")
        position=intent.getIntExtra("position",0)
  //   name[position!!] = RestuarensName[position!!]
      // Toast.makeText(this,"hey    " + position +restaurant,Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_foods)

        if(position == 0) {
            natan()

        }
        if(position == 1) {
         Bilos()

        }
        if(position == 2) {
            mamaschicken()
        }
        /*
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }
        if(RestuarensName == "MAMA'S Chicken") {
            mamaschicken()
        }*/


            listing.layoutManager = LinearLayoutManager(this)
            listing.adapter = ImagesAdapter(name,pics)

    }
    private fun addtolist(namelist:String,picslist:Int){
        name.add(namelist)
        pics.add((picslist))
    }
    private fun Bilos(){

        addtolist("Donat",R.drawable.donat)
        addtolist("Blackfoarst",R.drawable.cake3)

    }
    private fun mamaschicken(){
        addtolist("Beyayinet",R.drawable.beya)
        addtolist("Shiro",R.drawable.shiro)

    }
    private fun natan(){
        addtolist("Pasta",R.drawable.pasta)
        addtolist("Shiro",R.drawable.shiro)

    }
}