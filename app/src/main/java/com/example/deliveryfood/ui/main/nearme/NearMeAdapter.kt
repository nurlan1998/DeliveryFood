package com.example.deliveryfood.ui.main.nearme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.data.models.RestaurantsItem
import com.example.deliveryfood.other.Constants.BASE_URL
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlinx.android.synthetic.main.fragment_detail.view.*


class NearMeAdapter() : RecyclerView.Adapter<NearMeAdapter.NearMeViewHolder>() {
   // private lateinit var nearMeRvHorizontal: NearMeRvHorizontal

    var models: List<RestaurantsItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemClick: (RestaurantsItem) -> Unit

    fun setItemClick(itemClick: (model: RestaurantsItem) -> Unit){
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearMeViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)
        return NearMeViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: NearMeViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class NearMeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populate(restaurantsItem: RestaurantsItem) {



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

        }
    }



}