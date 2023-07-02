package com.example.recyclerwithdiffutil

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerwithdiffutil.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val placesList = arrayListOf<Place>()
    private lateinit var placesAdapter: PlaceAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initList()
        initRecyclerView()

        binding.fabAddItem.setOnClickListener {
            val list: MutableList<Place> = placesList.toMutableList()
            list.add(
                Place(
                    "WaterFall",
                    "https://images.unsplash.com/photo-1594092083575-f007edab410b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"

                )
            )
            placesAdapter.differ.submitList(list)
            binding.rvPlaces.smoothScrollToPosition(binding.rvPlaces.adapter!!.itemCount)
        }
    }

    private fun initRecyclerView() {

        placesAdapter = PlaceAdapter(this)
        binding.rvPlaces.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = placesAdapter
        }

    }


    private fun initList() {

        placesList.add(
            Place(
                "Sea",
                "https://images.unsplash.com/photo-1558901591-3a5f333830dd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"
            )
        )
        placesList.add(
            Place(
                "Tomb",
                "https://images.unsplash.com/photo-1570573057137-dfa2165e148e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"

            )
        )
        placesList.add(
            Place(
                "River Bridge",
                "https://images.unsplash.com/photo-1543574882-785d864cbaca?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1051&q=80"

            )
        )
        placesList.add(
            Place(
                "Mountain View",
                "https://images.unsplash.com/photo-1593461068733-7dffdd347dcd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"
            )
        )

        placesList.add(
            Place(
                "Sea",
                "https://images.unsplash.com/photo-1558901591-3a5f333830dd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"
            )
        )
        placesList.add(
            Place(
                "Tomb",
                "https://images.unsplash.com/photo-1570573057137-dfa2165e148e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"

            )
        )
        placesList.add(
            Place(
                "River Bridge",
                "https://images.unsplash.com/photo-1543574882-785d864cbaca?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1051&q=80"

            )
        )
        placesList.add(
            Place(
                "Mountain View",
                "https://images.unsplash.com/photo-1593461068733-7dffdd347dcd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"
            )
        )
        placesList.add(
            Place(
                "Sea",
                "https://images.unsplash.com/photo-1558901591-3a5f333830dd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"
            )
        )
        placesList.add(
            Place(
                "Tomb",
                "https://images.unsplash.com/photo-1570573057137-dfa2165e148e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"

            )
        )
        placesList.add(
            Place(
                "River Bridge",
                "https://images.unsplash.com/photo-1543574882-785d864cbaca?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1051&q=80"

            )
        )
        placesList.add(
            Place(
                "Mountain View",
                "https://images.unsplash.com/photo-1593461068733-7dffdd347dcd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80"
            )
        )

    }
}