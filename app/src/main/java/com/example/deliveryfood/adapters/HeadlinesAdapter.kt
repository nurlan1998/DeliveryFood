package com.example.deliveryfood.adapters

import com.example.deliveryfood.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deliveryfood.other.Constants
import com.example.deliveryfood.ui.menu.model.HeadlinesModel
import kotlinx.android.synthetic.main.item_headlines.view.*

class HeadlinesAdapter(context: Context) :
    RecyclerView.Adapter<HeadlinesAdapter.HeadlinesViewHolder>() {
    var items: List<HeadlinesModel>? = listOf()
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var count = 0

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
            it.findNavController().navigate(R.id.action_menuFragment_to_detailFragment)
        }

        holder.btnPlus.setOnClickListener {
            onItemClickCallBack?.addCard(item!!)
            onItemClickCallBack?.onItemClicked(count).also { count++ }
        }
        holder.btnMinus.setOnClickListener {
        }

        holder.tvTitle.text = item?.name
        holder.tvMenuPrice.text = item?.price
        Glide.with(holder.itemView.context).load(Constants.BASE_URL + item?.image)
            .into(holder.ivMenu)
//        Glide.with(holder.itemView.context).load(item?.image)
//            .into(holder.ivMenu)
    }

    private var onItemClickCallBack: OnItemClickCallBack? = null

    interface OnItemClickCallBack {
        fun onItemClicked(count: Int?)
        fun addCard(headlinesModel: HeadlinesModel)
    }

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override
    fun getItemCount(): Int {
        return items?.size ?: 0
    }

    class HeadlinesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tvMenuTitle)
        var tvMenuPrice: TextView = itemView.tvMenuPrice
        var ivMenu: ImageView = itemView.ivMenu
        var btnPlus: Button = itemView.btnMenuPlus
        var btnMinus: Button = itemView.btnMenuMinus
    }
}