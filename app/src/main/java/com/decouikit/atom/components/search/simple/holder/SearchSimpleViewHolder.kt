package com.decouikit.atom.components.search.simple.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.search.simple.interfaces.OnItemClickListener
import com.decouikit.atom.components.search.simple.model.SearchSimpleItem
import kotlinx.android.synthetic.main.adapter_search_item.view.*

class SearchSimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: SearchSimpleItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: SearchSimpleItem, listener: OnItemClickListener) {
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