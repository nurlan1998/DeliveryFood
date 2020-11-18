package com.example.deliveryfood.adapters

import com.example.deliveryfood.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.other.Constants
import com.example.deliveryfood.ui.menu.model.AddonCategory
import com.example.deliveryfood.ui.menu.model.HeadlinesModel
import kotlinx.android.synthetic.main.item_headlines.view.*

class HeadlinesAdapter(context: Context, data: List<HeadlinesModel>?) :
    RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>() {
    private var items: List<HeadlinesModel>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    private lateinit var itemClick: (HeadlinesModel) -> Unit

    fun setItemClick(itemClick: (model: HeadlinesModel) -> Unit) {
        this.itemClick = itemClick
    }

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlinesViewHolder {
        val view = inflater.inflate(R.layout.item_headlines, parent, false)
        return HeadlinesViewHolder(
            view
        )
    }

    override
    fun onBindViewHolder(holder: HeadlinesViewHolder, position: Int) {
        val item = items?.get(position)

        holder.itemView.setOnClickListener {
            itemClick.invoke(item!!)
        }

        holder.tvTitle.text = item?.name
        holder.tvMenuPrice.text = item?.price
        Glide.with(holder.itemView.context).load(Constants.BASE_URL + item?.image)
            .into(holder.ivMenu)
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class HeadlinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tvMenuTitle)
        var tvMenuPrice: TextView = itemView.tvMenuPrice
        var ivMenu: ImageView = itemView.ivMenu
    }
}