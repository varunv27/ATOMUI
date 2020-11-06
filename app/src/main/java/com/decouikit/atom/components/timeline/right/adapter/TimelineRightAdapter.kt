package com.decouikit.atom.components.timeline.right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.right.holder.TimelineRightViewHolder
import com.decouikit.atom.components.timeline.right.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.right.model.TimelineRightItem
import com.decouikit.atom.extensions.inflate

class TimelineRightAdapter(private var items: ArrayList<TimelineRightItem>) :
    RecyclerView.Adapter<TimelineRightViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineRightViewHolder {
        return TimelineRightViewHolder(parent.inflate(R.layout.adapter_timeline_right_item, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TimelineRightViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}