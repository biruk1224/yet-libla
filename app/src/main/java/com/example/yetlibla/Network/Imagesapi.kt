package com.example.yetlibla.Network


import android.provider.MediaStore
import android.renderscript.Sampler
import com.example.yetlibla.models.Images

import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://raw.githubusercontent.com/biruk1224/Jsonfile/main/db.json"
interface Imagesapi{
   @GET("images")
   fun getImages() : retrofit2.Call<List<Images>>
   companion object {
      operator fun invoke() : Imagesapi{
         return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Imagesapi::class.java)
      }
   }

}