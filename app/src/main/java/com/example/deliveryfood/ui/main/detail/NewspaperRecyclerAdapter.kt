package com.example.deliveryfood.ui.main.detail


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deliveryfood.R
import com.example.deliveryfood.ui.main.detail.model.NewspaperModel

class NewspaperAdapter(context: Context) :
    RecyclerView.Adapter<NewspaperAdapter.NewspaperViewHolder>() {
    private var mContext: Context = context

    //    private var items: List<NewspaperModel>? = data
    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var headlineAdapter: HeadlinesAdapter? = null

    var data: MutableList<NewspaperModel> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var itemClick: (NewspaperModel) -> Unit

    fun setItemClick(itemClick: (model: NewspaperModel) -> Unit) {
        this.itemClick = itemClick
    }


    override
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewspaperViewHolder {
        val view = inflater.inflate(R.layout.item_news_paper, parent, false)
        return NewspaperViewHolder(view)
    }

    override
    fun onBindViewHolder(holder: NewspaperViewHolder, position: Int) {
        val item = data?.get(position)

        holder.tvName.text = item?.papername
        headlineAdapter = HeadlinesAdapter(mContext, item.paperHeadlinesModel)
        holder.rvHeadlines.adapter = headlineAdapter
        holder.rvHeadlines.layoutManager = LinearLayoutManager(mContext)

        holder.itemView.setOnClickListener { onItemClicked(item) }
        if (item?.isExpanded!!) {
            holder.rvHeadlines.visibility = View.VISIBLE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_up)
        } else {
            holder.rvHeadlines.visibility = View.GONE
            holder.ivArrow.setImageResource(R.drawable.ic_arrow_down)
        }
    }

    override
    fun getItemCount(): Int {
        return data.size ?: 0
    }

    fun onItemClicked(newspaperModel: NewspaperModel?) {
        newspaperModel?.isExpanded = !newspaperModel?.isExpanded!!
        notifyDataSetChanged()
    }

    class NewspaperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvPaperName)
        var rvHeadlines: RecyclerView = itemView.findViewById(R.id.rvHeadlines)
        var ivArrow: ImageView = itemView.findViewById(R.id.ivArrow)
    }
}