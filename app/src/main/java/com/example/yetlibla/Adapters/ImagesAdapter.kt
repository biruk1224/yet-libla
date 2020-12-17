package com.example.yetlibla.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.unit.Position
import androidx.recyclerview.widget.RecyclerView
import com.example.yetlibla.R
import com.example.yetlibla.ui.Rating
import com.example.yetlibla.ui.foods
import com.example.yetlibla.ui.search
import kotlinx.android.synthetic.main.item_image.view.*

class ImagesAdapter(private var rating:List<String>,private var pics:List<Int>) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>(){
    inner class ViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){
        var itemrating: TextView = itemview.findViewById(R.id.rate)
        var itempic : ImageView =itemview.findViewById(R.id.image)
        init {
            itemview.setOnClickListener { View -> val position: Int = adapterPosition
              //  Toast.makeText(itemview.context,"successfull" +itemrating.text, Toast.LENGTH_LONG).show()
                val intent = Intent(itemview.context,foods::class.java)
                    intent.putExtra("restaurent",itemrating.text)
                itemview.context.startActivity(intent)



            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return rating.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemrating.text = rating[position]
        holder.itempic.setImageResource(pics[position])

    }




}