package com.decouikit.atom.components.timeline.left.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.left.holder.TimelineLeftViewHolder
import com.decouikit.atom.components.timeline.left.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.left.model.TimelineLeftItem
import com.decouikit.atom.extensions.inflate

class TimelineLeftAdapter(private var items: ArrayList<TimelineLeftItem>) :
    RecyclerView.Adapter<TimelineLeftViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineLeftViewHolder {
        return TimelineLeftViewHolder(parent.inflate(R.layout.adapter_timeline_left_item, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TimelineLeftViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}