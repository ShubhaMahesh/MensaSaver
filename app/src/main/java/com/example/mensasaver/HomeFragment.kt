package com.example.mensasaver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private val vegList = mutableListOf("Pizza Margharita", "Pommes", "Nudeln")
    private val vegImages = mutableListOf(R.drawable.pizza, R.drawable.pommes, R.drawable.nudeln)

    private val nonVegList = mutableListOf("wurst mit kartoffeln", "Chicken Burger", "Fisch")
    private val nonVegImages = mutableListOf(R.drawable.wurst, R.drawable.chicken_burger, R.drawable.fish)

    private lateinit var vegAdapter: DishAdapter
    private lateinit var nonVegAdapter: DishAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val vegRecycler = view.findViewById<RecyclerView>(R.id.vegRecycler)
        val nonVegRecycler = view.findViewById<RecyclerView>(R.id.nonVegRecycler)
        val addVegButton = view.findViewById<Button>(R.id.addVegButton)
        val addNonVegButton = view.findViewById<Button>(R.id.addNonVegButton)

        vegAdapter = DishAdapter(vegList, vegImages)
        nonVegAdapter = DishAdapter(nonVegList, nonVegImages)

        vegRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        nonVegRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        vegRecycler.adapter = vegAdapter
        nonVegRecycler.adapter = nonVegAdapter

        addVegButton.setOnClickListener {
            addItemToVeg("New Veg Dish", R.drawable.ic_add)
        }

        addNonVegButton.setOnClickListener {
            addItemToNonVeg("New Non-Veg Dish", R.drawable.ic_addnonveg)
        }

        return view
    }

    private fun addItemToVeg(name: String, image: Int) {
        vegList.add(name)
        vegImages.add(image)
        vegAdapter.notifyItemInserted(vegList.size - 1)
    }

    private fun addItemToNonVeg(name: String, image: Int) {
        nonVegList.add(name)
        nonVegImages.add(image)
        nonVegAdapter.notifyItemInserted(nonVegList.size - 1)
    }

    private fun deleteItemFromVeg(position: Int) {
        if (position in vegList.indices) {
            vegList.removeAt(position)
            vegImages.removeAt(position)
            vegAdapter.notifyItemRemoved(position)
        }
    }

    private fun deleteItemFromNonVeg(position: Int) {
        if (position in nonVegList.indices) {
            nonVegList.removeAt(position)
            nonVegImages.removeAt(position)
            nonVegAdapter.notifyItemRemoved(position)
        }
    }
}