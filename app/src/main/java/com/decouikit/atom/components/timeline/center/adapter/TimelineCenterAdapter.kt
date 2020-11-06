package com.decouikit.atom.components.timeline.center.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.center.holder.TimelineCenterLeftViewHolder
import com.decouikit.atom.components.timeline.center.holder.TimelineCenterRightViewHolder
import com.decouikit.atom.components.timeline.center.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.center.model.TimelineCenterItem
import com.decouikit.atom.components.timeline.center.model.TimelineType

class TimelineCenterAdapter(private var items: ArrayList<TimelineCenterItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun getItemViewType(position: Int): Int {
        return items[position].position.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TimelineType.LEFT.ordinal) {
            return TimelineCenterLeftViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.adapter_timeline_center_left_item,
                    parent,
                    false
                )
            )
        } else {
            return TimelineCenterRightViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.adapter_timeline_center_right_item,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TimelineType.LEFT.ordinal -> {
                listener?.let { (holder as TimelineCenterLeftViewHolder).bind(items[position], it) }
            }
            TimelineType.RIGHT.ordinal -> {
                listener?.let {
                    (holder as TimelineCenterRightViewHolder).bind(items[position],
                        it
                    )
                }
            }
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}