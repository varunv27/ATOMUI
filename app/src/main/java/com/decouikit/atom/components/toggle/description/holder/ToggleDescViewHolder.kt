package com.decouikit.atom.components.toggle.description.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.toggle.description.model.ToggleDescItem
import kotlinx.android.synthetic.main.adapter_toggle_desc.view.*

class ToggleDescViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: ToggleDescItem) {
        itemView.tvTitle.text = item.title
        itemView.tvDesc.text = item.desc
        itemView.toggle.isChecked = item.isSelected
    }
}