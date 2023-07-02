package com.example.recyclerwithdiffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PlaceAdapter(private val context: Context) :
    RecyclerView.Adapter<PlaceAdapter.PlacesViewHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem.placeImageUrl == newItem.placeImageUrl
        }

        override fun areContentsTheSame(oldItem: Place, newItem: Place): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlacesViewHolder {
        return PlacesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_places, parent, false)
        )

    }

    override fun onBindViewHolder(holder: PlacesViewHolder, position: Int) {
        val place = differ.currentList[position]
        holder.bind(place)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

   inner class PlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvPlacename: TextView = itemView.findViewById(R.id.tvPlaceName)
        val tvPlaceImage: ImageView = itemView.findViewById(R.id.ivPlacesImage)

        fun bind(place: Place) {

            place.let {
                tvPlacename.text = it.placeName
                Glide.with(context).load(it.placeImageUrl).into(tvPlaceImage)
            }

        }
    }
}

