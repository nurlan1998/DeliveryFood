package com.example.deliveryfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.ui.nearme.models.RestaurantResponse
import com.example.deliveryfood.other.Constants.BASE_URL
import kotlinx.android.synthetic.main.item_restaurant.view.*

class NearMeAdapter() : RecyclerView.Adapter<NearMeAdapter.NearMeViewHolder>() {

    var models: List<RestaurantResponse> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemClick: (RestaurantResponse) -> Unit

    fun setItemClick(itemClick: (model: RestaurantResponse) -> Unit) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearMeViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return NearMeViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: NearMeViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class NearMeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populate(restaurantsItem: RestaurantResponse) {

            itemView.tvNameRestaurant.text = restaurantsItem.name
            itemView.tvTypeFood.text = restaurantsItem.description
            itemView.tvRating.text = restaurantsItem.rating
            itemView.tvTimes.text = restaurantsItem.deliveryTime + " MINS"
            itemView.tvPrice.text = restaurantsItem.priceRange + " UZS"

            itemView.setOnClickListener {
                itemClick.invoke(restaurantsItem)
            }
            Glide.with(itemView.context).load(BASE_URL + restaurantsItem.image)
                .into(itemView.ivRestaurant)
//            Glide.with(itemView.context).load(restaurantsItem.image)
//                .into(itemView.ivRestaurant)

        }
    }
}