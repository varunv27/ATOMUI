package com.decouikit.atom.components.timeline.center.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.timeline.center.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.center.model.TimelineCenterItem
import kotlinx.android.synthetic.main.adapter_timeline_center_left_item.view.*

class TimelineCenterLeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: TimelineCenterItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: TimelineCenterItem, listener: OnItemClickListener) {
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