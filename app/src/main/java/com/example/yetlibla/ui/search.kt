package com.example.yetlibla.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yetlibla.Adapters.ImageAdapter
import com.example.yetlibla.R
import com.example.yetlibla.models.Images

class search : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        val images = listOf<Images>(
            Images(R.drawable.c),
            Images(R.drawable.d),
            Images(R.drawable.a),
            Images(R.drawable.w)
        )
        val recyclerView = findViewById<RecyclerView>(R.id.lists)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ImageAdapter(this,images)

    }
}