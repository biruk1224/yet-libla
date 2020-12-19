package com.example.yetlibla.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yetlibla.Adapters.ImageAdapter
import com.example.yetlibla.Adapters.ImagesAdapter
import com.example.yetlibla.R
import com.example.yetlibla.models.Images
import kotlinx.android.synthetic.main.activity_foods.*
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
        addtolist("Bilos Cafe",R.drawable.r1)
        addtolist("mamas chicken Restaurant",R.drawable.r2)

    }
}