package com.decouikit.atom.components.toggle.group.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.toggle.group.holder.ToggleSimpleViewHolder
import com.decouikit.atom.components.toggle.group.model.ToggleSimpleItem
import com.decouikit.atom.extensions.inflate

class ToggleSimpleAdapter(private var list: List<ToggleSimpleItem>)
    : RecyclerView.Adapter<ToggleSimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToggleSimpleViewHolder {
        return ToggleSimpleViewHolder(parent.inflate(R.layout.adapter_toggle_simple, false))
    }

    override fun onBindViewHolder(viewHolder: ToggleSimpleViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}