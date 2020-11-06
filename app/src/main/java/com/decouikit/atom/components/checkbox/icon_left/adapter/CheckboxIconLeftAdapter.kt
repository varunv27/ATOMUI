package com.decouikit.atom.components.checkbox.icon_left.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.icon_left.holder.CheckboxIconLeftViewHolder
import com.decouikit.atom.components.checkbox.icon_left.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxIconLeftAdapter(private var list: List<CheckBoxItem>)
    : RecyclerView.Adapter<CheckboxIconLeftViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxIconLeftViewHolder {
        return CheckboxIconLeftViewHolder(parent.inflate(R.layout.adapter_checkbox_image_left, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxIconLeftViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}