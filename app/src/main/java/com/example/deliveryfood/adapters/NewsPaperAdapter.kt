package com.example.deliveryfood.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.ui.menu.model.NewsPaperModel

class NewsPaperAdapter(context: Context) :
    RecyclerView.Adapter<NewsPaperAdapter.NewspaperViewHolder>() {
    private var mContext: Context = context
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var headlineAdapter: HeadlinesAdapter? = null

    var data: MutableList<NewsPaperModel> = mutableListOf()
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
        val item = data[position]

        holder.tvName.text = item.name
        headlineAdapter = HeadlinesAdapter(
            mContext,
            item.foods
        )

        headlineAdapter!!.setItemClick {
           Navigation.findNavController(mContext as Activity,R.id.action_menuFragment_to_detailFragment)
        }

        holder.rvHeadlines.adapter = headlineAdapter
        holder.rvHeadlines.layoutManager = LinearLayoutManager(mContext)

        holder.itemView.setOnClickListener { onItemClicked(item) }
        if (item.isExpanded!!) {
            holder.rvHeadlines.visibility = View.VISIBLE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.rvHeadlines.visibility = View.GONE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_down)
        }
    }

    override
    fun getItemCount(): Int {
        return data.size
    }

    fun onItemClicked(newspaperModel: NewsPaperModel) {
        newspaperModel.isExpanded = !newspaperModel.isExpanded!!
        notifyDataSetChanged()
    }

    class NewspaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvPaperName)
        var rvHeadlines: RecyclerView = itemView.findViewById(R.id.rvHeadlines)
        var ivArrow: ImageView = itemView.findViewById(R.id.ivArrow)
    }
}