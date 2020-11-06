package com.decouikit.atom.components.checkbox.simple_left.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.checkbox.simple_left.model.CheckBoxItem
import kotlinx.android.synthetic.main.adapter_checkbox_simple_left.view.*

class CheckboxSimpleLeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: CheckBoxItem) {
        itemView.checkbox.text = item.title
    }
}