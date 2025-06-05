package com.example.mensasaver

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DishAdapter(private val dishNames: List<String>, private val dishImages: List<Int>) :
    RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    inner class DishViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dishImage = view.findViewById<ImageView>(R.id.dishImage)
        val dishName = view.findViewById<TextView>(R.id.dishName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.dishImage.setImageResource(dishImages[position])
        holder.dishName.text = dishNames[position]
    }

    override fun getItemCount(): Int = dishNames.size
}
