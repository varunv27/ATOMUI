package com.decouikit.atom.components.timeline.left.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.timeline.left.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.left.model.TimelineLeftItem
import kotlinx.android.synthetic.main.adapter_timeline_left_item.view.*

class TimelineLeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: TimelineLeftItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: TimelineLeftItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemView.textTitle.text = item.title
        itemView.textSubtitle.text = item.subtitle
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