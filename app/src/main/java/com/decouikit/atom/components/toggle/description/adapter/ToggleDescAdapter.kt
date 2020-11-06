package com.decouikit.atom.components.toggle.description.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.toggle.description.holder.ToggleDescViewHolder
import com.decouikit.atom.components.toggle.description.model.ToggleDescItem
import com.decouikit.atom.extensions.inflate

class ToggleDescAdapter(private var list: List<ToggleDescItem>)
    : RecyclerView.Adapter<ToggleDescViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToggleDescViewHolder {
        return ToggleDescViewHolder(parent.inflate(R.layout.adapter_toggle_desc, false))
    }

    override fun onBindViewHolder(viewHolder: ToggleDescViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}