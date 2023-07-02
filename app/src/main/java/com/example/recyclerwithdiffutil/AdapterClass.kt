package com.example.recyclerwithdiffutil

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerwithdiffutil.PlaceAdapter.PlacesViewHolder
import com.example.recyclerwithdiffutil.databinding.ActivityMainBinding
import com.example.recyclerwithdiffutil.databinding.ItemPlacesBinding

class AdapterClass() : ListAdapter<Place, AdapterClass.PlacesViewHolder>(ItemDiffCallBack()) {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClass.PlacesViewHolder {

//       return PlacesViewHolder(ItemPlacesBinding.inflate(
//            LayoutInflater.from(parent.context),
//            parent,
//            false
//
//        ))
        return PlacesViewHolder(
            parent.context.getSystemService(LayoutInflater::class.java).inflate(
                R.layout.item_places,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    inner class PlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val tvPlacename: TextView = itemView.findViewById(R.id.tvPlaceName)
            val tvPlaceImage: ImageView = itemView.findViewById(R.id.ivPlacesImage)

            fun bind(place: Place) {

                place.let {
                    tvPlacename.text = it.placeName
                  // Glide.with(context).load(it.placeImageUrl).into(tvPlaceImage)
                }
        }
    }

}
    class ItemDiffCallBack : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.placeImageUrl == newItem.placeImageUrl
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }


    }


