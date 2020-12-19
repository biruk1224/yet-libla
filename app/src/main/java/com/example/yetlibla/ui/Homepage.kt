package com.example.yetlibla.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.yetlibla.Adapters.ImagesAdapter
import com.example.yetlibla.Network.Imagesapi
import com.example.yetlibla.R
import com.example.yetlibla.models.Images
import kotlinx.android.synthetic.main.activity_homepage.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Homepage : AppCompatActivity() {
    private var names = mutableListOf<String>()
    private var pics = mutableListOf<Int>()
    private var price= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)


     // fetchMovies()
       /* val images = listOf<Images>(
            Images(R.drawable.c),
            Images(R.drawable.d),
            Images(R.drawable.a),
            Images(R.drawable.w)
        )*/
        posttolist()
     //   val recyclerView = findViewById<RecyclerView>(R.id.list)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = ImagesAdapter(names,pics,price)
       // recyclerView.setHasFixedSize(true)
      //  recyclerView.adapter = ImageAdapter(this,images)



    }
    private fun addtolist(namelist: String, picslist: Int, s: String){
        names.add(namelist)
        pics.add((picslist))
        price.add(s)
    }
    private fun posttolist(){
        addtolist("Beyayinet",R.drawable.beya,"35birr")
        addtolist("Black foarst",R.drawable.donat,"65birr")
        addtolist("Shiro",R.drawable.shiro,"40birr")

    }
    private fun fetchMovies(){


        Imagesapi().getImages().enqueue(object : Callback<List<Images>> {
            override fun onFailure(call: Call<List<Images>>, t: Throwable) {

                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Images>>, response: Response<List<Images>>) {

                val images = response.body()

                images?.let {
                    showMovies(it)
                }

            }

        })
    }
    private fun showMovies(images: List<Images>) {
      //  list.layoutManager = LinearLayoutManager(this)
      //  list.adapter = ImageAdapter(images)
    }

    fun onClick(view: View) {
       // Toast.makeText(applicationContext,"successfull", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,search::class.java))

    }
}