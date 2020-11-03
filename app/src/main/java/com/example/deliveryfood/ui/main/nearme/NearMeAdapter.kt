package com.example.deliveryfood.ui.main.nearme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.data.models.expandable.CurrentLocationItem
import kotlinx.android.synthetic.main.restaurant_item.view.*
//
//class NearMeAdapter() : RecyclerView.Adapter<NearMeAdapter.NearMeViewHolder>() {
//
//    var models: List<CurrentLocationItem> = listOf()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }
//
//    private lateinit var itemClick: (CurrentLocationItem) -> Unit
//
//    fun setItemClick(itemClick: (model: CurrentLocationItem) -> Unit){
//        this.itemClick = itemClick
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearMeViewHolder {
//        var view =
//            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item, parent, false)
//        return NearMeViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = models.size
//
//    override fun onBindViewHolder(holder: NearMeViewHolder, position: Int) {
//        holder.populate(models[position])
//    }
//
//    inner class NearMeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun populate(currentLocationItem: CurrentLocationItem) {
//            itemView.tvNameRestaurant.text = currentLocationItem.name
//            itemView.tvTypeFood.text = currentLocationItem.description
//
//            itemView.setOnClickListener {
//                itemClick.invoke(currentLocationItem)
//            }
//
//            Glide.with(itemView.context).load(currentLocationItem.image)
//                .into(itemView.ivRestaurant)
//        }
//    }
//}