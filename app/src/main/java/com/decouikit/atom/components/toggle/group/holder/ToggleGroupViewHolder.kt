package com.decouikit.atom.components.toggle.group.holder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.toggle.group.adapter.ToggleSimpleAdapter
import com.decouikit.atom.components.toggle.group.model.ToggleGroupItem
import kotlinx.android.synthetic.main.adapter_toggle_group_item.view.*

class ToggleGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ToggleGroupItem) {
        itemView.tvTitle.text = item.title
        itemView.rvList.layoutManager = LinearLayoutManager(itemView.context)
        itemView.rvList.adapter = item.subItems?.let { ToggleSimpleAdapter(it) }
    }
}