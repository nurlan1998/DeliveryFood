package com.example.deliveryfood.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.ui.menu.model.HeadlinesMenu
import com.example.deliveryfood.ui.menu.model.NewsPaperMenu
import kotlinx.android.synthetic.main.item_news_paper.view.*
import kotlinx.android.synthetic.main.layout_header.view.*

class NewsPaperAdapter(context: Context) :
    RecyclerView.Adapter<NewsPaperAdapter.NewspaperViewHolder>() {
    private var mContext: Context = context
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var headlineAdapter: HeadlinesAdapter? = null
    private var onItemClick: OnItemClick? = null
    private var horizontalMenuAdapter:HorizontalMenuAdapter? = null

    var data: MutableList<NewsPaperMenu> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var models: MutableList<HeadlinesMenu> = mutableListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewspaperViewHolder {
        val view = inflater.inflate(R.layout.item_news_paper, parent, false)
        return NewspaperViewHolder(
            view
        )
    }

    override
    fun onBindViewHolder(holder: NewspaperViewHolder, position: Int) {
        holder.bind(data[position])
        if(position == 0){
            holder.itemView.rvHeader.visibility = View.VISIBLE
        }else{
            holder.itemView.rvHeader.visibility = View.GONE
        }
    }

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    override
    fun getItemCount(): Int {
        return data.size
    }

    fun onItemClickedExpandable(newspaperMenu: NewsPaperMenu) {
        newspaperMenu.isExpanded = !newspaperMenu.isExpanded!!
        notifyDataSetChanged()
    }

    inner class NewspaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(newspaperMenu: NewsPaperMenu)
        {
            itemView.tvPaperName.text = newspaperMenu.name

            headlineAdapter = HeadlinesAdapter(mContext)
            itemView.rvHeadlines.layoutManager = LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
            itemView.rvHeadlines.adapter = headlineAdapter
            headlineAdapter!!.items = newspaperMenu.headlines!!

            horizontalMenuAdapter = HorizontalMenuAdapter()
            val layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
            itemView.rvHeader.layoutManager = layoutManager
            itemView.rvHeader.adapter = horizontalMenuAdapter
            horizontalMenuAdapter!!.models = models

            horizontalMenuAdapter!!.setOnItemClickHorizontal(object : OnItemClick{
                override fun deleteCart(headlinesMenu: HeadlinesMenu) {
                    onItemClick?.deleteCart(headlinesMenu)
                }

                override fun addCard(headlinesMenu: HeadlinesMenu) {
                    onItemClick?.addCard(headlinesMenu)
                }
            })

            headlineAdapter!!.setOnItemClickHeadline(object : OnItemClick {
                override fun deleteCart(headlinesMenu: HeadlinesMenu) {
                    onItemClick?.deleteCart(headlinesMenu = headlinesMenu)
                }

                override fun addCard(headlinesMenu: HeadlinesMenu) {
                    onItemClick?.addCard(headlinesMenu = headlinesMenu)
                }
            })

            itemView.setOnClickListener { onItemClickedExpandable(newspaperMenu) }
            if (newspaperMenu.isExpanded!!) {
                itemView.rvHeadlines.visibility = View.VISIBLE
                itemView.ivArrow.setImageResource(R.drawable.ic_arrow_up)
            } else {
                itemView.rvHeadlines.visibility = View.GONE
                itemView.ivArrow.setImageResource(R.drawable.ic_arrow_down)
            }
        }
    }
}