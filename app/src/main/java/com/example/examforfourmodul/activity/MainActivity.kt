package com.example.examforfourmodul.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examforfourmodul.R
import com.example.examforfourmodul.adapter.RestaurantAdapter
import com.example.examforfourmodul.model.Restaurant
import android.telephony.TelephonyManager
import android.util.Log
import com.example.examforfourmodul.listener.OnListener


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)

        val manager : TelephonyManager = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

        if(manager.phoneType == TelephonyManager.PHONE_TYPE_NONE){
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        }else{
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        }

        refreshAdapter(prepareList())
    }
    private fun refreshAdapter(array : ArrayList<Restaurant>){
        var adapter = RestaurantAdapter(array, object : OnListener {
            override fun atTheEnd(position: Int) {
                Log.d("@@@", "@@@position$position")
            }
        })

        recyclerView.adapter = adapter
    }

    private fun prepareList(): ArrayList<Restaurant>{
        val restautarnts = ArrayList<Restaurant>()

        restautarnts.add(Restaurant(R.drawable.img_r1,"Restaurant 1", "$100", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r2,"Restaurant 2", "$120", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r3,"Restaurant 3", "$140", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r4,"Restaurant 4", "$150", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r5,"Restaurant 5", "$160", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r6,"Restaurant 6", "$170", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r7,"Restaurant 7", "$130", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r8,"Restaurant 8", "$100", "In Tashkent"))
        restautarnts.add(Restaurant(R.drawable.img_r9,"Restaurant 9", "$140", "In Tashkent"))
        return restautarnts
    }
}