package com.example.deliveryfood.ui.main.nearme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.data.models.SingleRestaurant
import kotlinx.android.synthetic.main.restaurant_item.view.*

class NearMeAdapter : RecyclerView.Adapter<NearMeAdapter.NearMeViewHolder>() {

    var models: List<SingleRestaurant> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
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
        fun populate(singleRestaurant: SingleRestaurant) {
            itemView.tvNameRestaurant.text = singleRestaurant.name
            itemView.tvTypeFood.text = singleRestaurant.address

            Glide.with(itemView.context).load(singleRestaurant.imageUrl)
                .into(itemView.ivRestaurant)
        }
    }
}