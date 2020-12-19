package com.example.yetlibla.Adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.yetlibla.R
import com.example.yetlibla.ui.Location
import com.example.yetlibla.ui.Single

class ImagesAdapter(private var names:List<String>, private var pics:List<Int>) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>(){
    inner class ViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){
        var itemnames: TextView = itemview.findViewById(R.id.rate)
        var itempic : ImageView =itemview.findViewById(R.id.imageView)
        init {
            itemview.setOnClickListener { View -> val position: Int = adapterPosition
             //  Toast.makeText(itemview.context,"successfull" +itemnames.text + position + adapterPosition, Toast.LENGTH_LONG).show()
                val intent = Intent(itemview.context, Single::class.java)
                   intent.putExtra("name",itemnames.text)
                    intent.putExtra("position",position)
                     itemview.context.startActivity(intent)



            }
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemnames.text = names[position]
        holder.itempic.setImageResource(pics[position])

    }




}