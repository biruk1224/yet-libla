package com.example.yetlibla.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.yetlibla.R
import com.example.yetlibla.models.Images
import com.example.yetlibla.ui.Homepage
import kotlinx.android.synthetic.main.item_image.view.*

/*
class ImageAdapter (val images: List<Images>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)

        )
    }

    override fun getItemCount(): Int = images.size



    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]

        Glide.with(holder.view.context)
            .load(image.imagey)
            .into(holder.view.image)
    }

    class ImageViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}*/

class ImageAdapter(private val context : Context, private val images : List <Images>  ) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bindView(image: Images) {
            img.setImageResource(image.imagey)


        }
        val img = itemView.findViewById<ImageView>(R.id.image)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image,parent,false))


    override fun getItemCount(): Int = images.size



    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(images[position])
    }

}