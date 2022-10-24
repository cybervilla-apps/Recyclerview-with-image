package com.cybervilla.recyclerviewwithimage

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlin.random.Random

class MainActivity : AppCompatActivity(),AdapterMain.OnItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapterMain: AdapterMain
    lateinit var btnUpdate: Button
    lateinit var listOfString: ArrayList<Sample>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_main_update)
        btnUpdate = findViewById(R.id.btn_update)
        listOfString = ArrayList()
        adapterMain = AdapterMain(listOfString,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterMain
        updateRecyclerview()
        btnUpdate.setOnClickListener {
            updateRecyclerview()
        }
    }
    fun updateRecyclerview(){
        listOfString.clear()
        for (i in 1..50){
//            listOfString.add("Test item ${Random.nextInt()}")
            listOfString.add(Sample("Test item ${Random.nextInt()}"
                ,getImageDrawable(Random.nextInt(1,7))))
        }
        adapterMain.update(listOfString)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item pos = $position", Toast.LENGTH_SHORT).show()
    }

    fun getImageDrawable(i: Int): Int{
        when(i){
            1-> return R.drawable.sample_1
            2-> return R.drawable.sample_2
            3-> return R.drawable.sample_3
            4-> return R.drawable.sample_4
            5-> return R.drawable.sample_5
            6-> return R.drawable.sample_6
            7-> return R.drawable.sample_7
            else-> return R.drawable.sample_1
        }
    }
}