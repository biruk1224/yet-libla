package com.example.yetlibla.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yetlibla.Adapters.ImageAdapter
import com.example.yetlibla.R
import kotlinx.android.synthetic.main.activity_search.*

class search : AppCompatActivity() {
    private var names = mutableListOf<String>()
    private var pics = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        mamaschicken()


        lists.layoutManager = LinearLayoutManager(this)
        lists.adapter = ImageAdapter(names,pics)

    }
    private fun addtolist(namelist:String,picslist:Int){
        names.add(namelist)
        pics.add((picslist))
    }
    private fun mamaschicken(){
        addtolist("Natan Restaurant",R.drawable.r)
        addtolist("Bilos Cafe",R.drawable.r)
        addtolist("mamas chicken Restaurant",R.drawable.r)

    }
}