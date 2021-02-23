package com.icbt.magula.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.icbt.magula.R
import com.icbt.magula.data.network.ServiceResponse

class HomeRecyclerViewAdapter(private val hotels: List<ServiceResponse>,val images: List<Int>)
    :RecyclerView.Adapter<HomeRecyclerViewAdapter.HomeRecyclerViewHolder>() {

    class HomeRecyclerViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageView:ImageView = view.findViewById(R.id.hotel_image_view)
        val textView:TextView = view.findViewById(R.id.hotel_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item,parent,false)
        return HomeRecyclerViewHolder(layout)
    }

    override fun getItemCount(): Int = hotels.size

    override fun onBindViewHolder(holder: HomeRecyclerViewHolder, position: Int) {

        holder.imageView.setImageResource(images[position])
        holder.textView.text = hotels[position].hotelName.toString()

    }
}