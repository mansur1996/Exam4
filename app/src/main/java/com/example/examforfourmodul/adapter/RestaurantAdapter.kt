package com.example.examforfourmodul.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examforfourmodul.R
import com.example.examforfourmodul.listener.OnListener
import com.example.examforfourmodul.model.Restaurant

class RestaurantAdapter(val restaurants : ArrayList<Restaurant>, val listener : OnListener) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurants, parent, false)
        return RestautantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position == restaurants.size - 1) {
            listener.atTheEnd(position)
        }

        val restaurant = restaurants[position]

        if(holder is RestautantViewHolder){
            holder.apply {
                img.setImageResource(restaurant.image)
                name.text = restaurant.name
                pr.text = restaurant.price
                des.text = restaurant.des
            }
        }
    }

    override fun getItemCount(): Int = restaurants.size

    class RestautantViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var img = view.findViewById<ImageView>(R.id.iv_img)
        var name = view.findViewById<TextView>(R.id.tv_name)
        var pr = view.findViewById<TextView>(R.id.tv_price)
        var des = view.findViewById<TextView>(R.id.tv_destination)
    }
}