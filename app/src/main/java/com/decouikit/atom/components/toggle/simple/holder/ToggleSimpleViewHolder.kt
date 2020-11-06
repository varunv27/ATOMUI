package com.decouikit.atom.components.toggle.simple.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.toggle.simple.model.ToggleSimpleItem
import kotlinx.android.synthetic.main.adapter_toggle_simple.view.*

class ToggleSimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ToggleSimpleItem) {
        itemView.tvTitle.text = item.title
        itemView.toggle.isChecked = item.isSelected
    }
}