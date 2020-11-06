package com.decouikit.atom.components.cards.ecommerce_thumb.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.cards.ecommerce_thumb.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_thumb.model.ThumbItem
import kotlinx.android.synthetic.main.adapter_parallax_shopping_item.view.*

class ThumbViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

        private var listener: OnItemClickListener? = null
        private var item: ThumbItem? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: ThumbItem, listener: OnItemClickListener) {
            this.item = item
            this.listener = listener

            itemView.tvItemTitle.text = item.title
        itemView.ivItemBg.setImageDrawable(item.backgroundPhotoDrawableRes?.let {
            ContextCompat.getDrawable(
                itemView.context,
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