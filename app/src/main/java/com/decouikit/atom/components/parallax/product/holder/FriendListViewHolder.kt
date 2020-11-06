package com.decouikit.atom.components.parallax.product.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.parallax.product.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.product.model.FriendListItem
import kotlinx.android.synthetic.main.adapter_card_image.view.*

class FriendListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {


    private var listener: OnItemClickListener? = null
    private var item: FriendListItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: FriendListItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener
        itemView.tvItemTitle.text = item.title
        itemView.tvItemSubtitle.text = item.subtitle
        itemView.ivItemBg.setImageDrawable(item.backgroundPhotoDrawableRes?.let {
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