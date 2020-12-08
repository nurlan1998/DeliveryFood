package com.example.deliveryfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.other.Constants.BASE_URL
import com.example.deliveryfood.ui.menu.model.Recommended
import com.example.deliveryfood.ui.nearme.models.MainSlide
import com.example.deliveryfood.ui.nearme.models.RestaurantResponse
import kotlinx.android.synthetic.main.item_horizontal.view.*

class HorizontalAdapter() : RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>() {

    var models: List<MainSlide> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private lateinit var itemClick: (MainSlide) -> Unit

    fun setItemClick(itemClick: (model: MainSlide) -> Unit) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        var viewHorizontal = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal, parent, false)
        return HorizontalViewHolder(viewHorizontal)
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(models[position])
    }

    inner class HorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mainSlide: MainSlide) {

            itemView.setOnClickListener {
                itemClick.invoke(mainSlide)
            }
            Glide.with(itemView.context).load(BASE_URL + mainSlide.image)
                .into(itemView.iv_image_horizontal)
        }
    }
}