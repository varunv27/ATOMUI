package com.decouikit.atom.components.lists.drag_and_drop.holder

import android.view.View
import androidx.core.content.ContextCompat
import com.decouikit.atom.components.lists.drag_and_drop.interfaces.OnItemClickListener
import com.decouikit.atom.components.lists.drag_and_drop.model.DragAndDropViewItem
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder
import kotlinx.android.synthetic.main.adapter_list_drag_and_drop_item.view.*

class DragAndDropViewHolder(itemView: View) : AbstractDraggableItemViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: DragAndDropViewItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: DragAndDropViewItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemView.tvItemTitle.text = item.title
        itemView.ivAvatar.setImageDrawable(item.avatarDrawableRes?.let {
            ContextCompat.getDrawable(
                itemView.context, it
            )
        })
    }

    override fun onClick(v: View?) {
        item?.let { listener?.onItemClick(it) }
    }
}