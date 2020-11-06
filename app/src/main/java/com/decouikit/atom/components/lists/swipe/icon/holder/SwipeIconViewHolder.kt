package com.decouikit.atom.components.lists.swipe.icon.holder

import android.view.View
import androidx.core.content.ContextCompat
import com.decouikit.atom.components.lists.swipe.icon.interfaces.OnSwipeItemListener
import com.decouikit.atom.components.lists.swipe.icon.model.SwipeViewItem
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder
import kotlinx.android.synthetic.main.adapter_swipe_icon_item.view.*

class SwipeIconViewHolder(itemView: View) : AbstractSwipeableItemViewHolder(itemView),
    View.OnClickListener {

    private lateinit var item: SwipeViewItem
    private var listener: OnSwipeItemListener? = null
    private var itemPosition: Int = 0

    override fun getSwipeableContainerView(): View {
        return itemView.container
    }

    init {
        itemView.setOnClickListener(this)
        itemView.btnAdd.setOnClickListener(this)
        itemView.btnRemove.setOnClickListener(this)
    }

    fun bind(item: SwipeViewItem, listener: OnSwipeItemListener, position: Int) {

        this.item = item
        this.listener = listener
        itemPosition = position

        itemView.textName.text = item.title
        itemView.imageAvatar.setImageDrawable(item.avatarDrawableRes?.let {
            ContextCompat.getDrawable(
                itemView.imageAvatar.context,
                it
            )
        })
    }

    override fun onClick(v: View) {
        when (v) {
            itemView -> {
                listener?.onItemClick(item)
            }
            itemView.btnAdd -> {
                listener?.addItem(v, item, itemPosition)
            }
            itemView.btnRemove -> {
                listener?.removeItem(v, item, itemPosition)
            }
        }
    }
}