package com.example.deliveryfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.ui.cart.model.CartData
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import kotlinx.android.synthetic.main.item_cart.view.*

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var onItemClickCart: OnItemClick? = null

    var models: List<HeadlinesMenu> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart,parent,false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.populate(models[position])
    }

    inner class CartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun populate(headlinesMenu: HeadlinesMenu){
            itemView.tvProductTitle.text = headlinesMenu.name
            itemView.tvProductPrice.text = headlinesMenu.price
//            itemView.btnProductCount.text = headlinesMenu.quantity

            itemView.btnProductAdd.setOnClickListener {
                onItemClickCart?.addCard(headlinesMenu)
            }
            itemView.btnProductDelete.setOnClickListener {
                onItemClickCart?.deleteCart(headlinesMenu)
            }
        }
    }

    fun setOnItemClickHeadline(onItemClick: OnItemClick) {
        this.onItemClickCart = onItemClick
    }
}