package com.example.deliveryfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.other.Constants
import com.example.deliveryfood.ui.menu.model.Recommended
import com.example.deliveryfood.ui.nearme.models.MainSlide
import kotlinx.android.synthetic.main.item_horizontal.view.*

class HorizontalMenuAdapter: RecyclerView.Adapter<HorizontalMenuAdapter.HorizontalMenuViewHolder>() {

    var models: List<Recommended> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemClick: (Recommended) -> Unit

    fun setItemClick(itemClick: (model: Recommended) -> Unit) {
        this.itemClick = itemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalMenuViewHolder {
        var viewHorizontal = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horizontal, parent, false)
        return HorizontalMenuViewHolder(viewHorizontal)
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: HorizontalMenuViewHolder, position: Int) {
        holder.bind(models[position])
    }

    inner class HorizontalMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(recommended: Recommended) {

            itemView.btnHorizontalAdd.visibility = View.VISIBLE
            itemView.btnHorizontalDelete.visibility = View.VISIBLE
            itemView.tv_horizontal_title.visibility = View.VISIBLE
            itemView.tv_horizontal_price.visibility = View.VISIBLE

            itemView.setOnClickListener {
                itemClick.invoke(recommended)
            }

            Glide.with(itemView.context).load(Constants.BASE_URL + recommended.image)
                .into(itemView.iv_image_horizontal)
        }
    }
}