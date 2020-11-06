package com.decouikit.atom.components.search.top_bar.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.search.top_bar.interfaces.OnItemClickListener
import com.decouikit.atom.components.search.top_bar.model.SearchTopBarItem
import kotlinx.android.synthetic.main.adapter_search_item.view.*

class SearchTopBarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: SearchTopBarItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: SearchTopBarItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemView.textTitle.text = item.title
        itemView.textSubtitle.text = item.title
        itemView.imageAvatar.setImageDrawable(item.avatarDrawableRes?.let {
            ContextCompat.getDrawable(itemView.context,
                it
            )
        })
    }

    override fun onClick(v: View?) {
        when (v) {
            itemView -> {
                item?.let { listener?.onItemClick(it) }
            }
        }
    }
}