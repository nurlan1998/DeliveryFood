package com.example.deliveryfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.R
import com.example.deliveryfood.other.Constants
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import com.example.deliveryfood.ui.menu.model.Recommended
import com.example.deliveryfood.ui.menu.view.MenuFragmentDirections
import com.example.deliveryfood.ui.nearme.models.MainSlide
import kotlinx.android.synthetic.main.item_horizontal.view.*

class HorizontalMenuAdapter: RecyclerView.Adapter<HorizontalMenuAdapter.HorizontalMenuViewHolder>() {

    private var onItemClick: OnItemClick? = null
    private lateinit var itemClick: (HeadlinesMenu) -> Unit

    var models: List<HeadlinesMenu> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun setItemClick(itemClick: (model: HeadlinesMenu) -> Unit) {
        this.itemClick = itemClick
    }
    fun setOnItemClickHorizontal(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
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
        fun bind(headlinesMenu: HeadlinesMenu) {

            itemView.btnHorizontalAdd.visibility = View.VISIBLE
            itemView.btnHorizontalDelete.visibility = View.VISIBLE
            itemView.tv_horizontal_title.visibility = View.VISIBLE
            itemView.tv_horizontal_price.visibility = View.VISIBLE

            itemView.btnHorizontalAdd.setOnClickListener {
                onItemClick?.addCard(headlinesMenu)
            }
            itemView.btnHorizontalDelete.setOnClickListener {
                onItemClick?.deleteCart(headlinesMenu)
            }

            itemView.setOnClickListener {
                itemClick.invoke(headlinesMenu)
            }
            itemView.setOnClickListener {
                var action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(headlinesMenu.id)
                it.findNavController().navigate(action)
            }

            Glide.with(itemView.context).load(Constants.BASE_URL + headlinesMenu.image)
                .into(itemView.iv_image_horizontal)
        }
    }
}