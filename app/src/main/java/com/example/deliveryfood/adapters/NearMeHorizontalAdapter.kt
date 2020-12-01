package com.example.deliveryfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.data.models.RestaurantsItem
import com.example.deliveryfood.other.Constants.BASE_URL
import kotlinx.android.synthetic.main.restourant_horizontal_item.view.*

class NearMeHorizontalAdapter : RecyclerView.Adapter<NearMeHorizontalAdapter.NearMe>() {

    var horizontalModel: List<RestaurantsItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class NearMe(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(nearMeRvHorizontal: RestaurantsItem) {


            Glide.with(itemView.context).load(BASE_URL + nearMeRvHorizontal.image)
                .into(itemView.iv_image_horizontal)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearMe {
        var viewHorizontal = LayoutInflater.from(parent.context)
            .inflate(R.layout.restourant_horizontal_item, parent, false)
        return NearMe(viewHorizontal)
    }

    override fun getItemCount(): Int = horizontalModel.size

    override fun onBindViewHolder(holder: NearMe, position: Int) {
        holder.bind(horizontalModel[position])

    }
}