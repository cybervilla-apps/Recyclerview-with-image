package com.cybervilla.recyclerviewwithimage

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation

class AdapterMain(var listOfStrings:ArrayList<Sample>,
                  var onItemClickListener: OnItemClickListener)
    :RecyclerView.Adapter<AdapterMain.MyViewHolder>(){
    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }
   fun update(list : ArrayList<Sample>){
        listOfStrings = ArrayList()
       listOfStrings.addAll(list)
       notifyDataSetChanged()
    }
    class MyViewHolder(itemView: View, onItemClickListener: OnItemClickListener)
        :RecyclerView.ViewHolder(itemView){
            val txtMain = itemView.findViewById<TextView>(R.id.txt_main)
            val imgTest = itemView.findViewById<ImageView>(R.id.img_test)
        init {
            itemView.setOnClickListener {
                onItemClickListener.onItemClick(adapterPosition)
            }
        }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_update,parent
        ,false)
        return MyViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sample = listOfStrings[position]
        holder.txtMain.text = sample.text
        holder.imgTest.load(sample.resId){
            crossfade(true)
            placeholder(R.drawable.sample_1)
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount(): Int {
        return listOfStrings.size
    }
}