package com.decouikit.atom.components.toggle.group.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.toggle.group.holder.ToggleGroupViewHolder
import com.decouikit.atom.components.toggle.group.model.ToggleGroupItem
import com.decouikit.atom.extensions.inflate

class ToggleGroupAdapter(private var list: List<ToggleGroupItem>)
    : RecyclerView.Adapter<ToggleGroupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToggleGroupViewHolder {
        return ToggleGroupViewHolder(parent.inflate(R.layout.adapter_toggle_group_item, false))
    }

    override fun onBindViewHolder(viewHolder: ToggleGroupViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}