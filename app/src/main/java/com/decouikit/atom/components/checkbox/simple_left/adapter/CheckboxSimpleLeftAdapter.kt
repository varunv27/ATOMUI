package com.decouikit.atom.components.checkbox.simple_left.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.simple_left.holder.CheckboxSimpleLeftViewHolder
import com.decouikit.atom.components.checkbox.simple_left.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxSimpleLeftAdapter(private var list: List<CheckBoxItem>)
    : RecyclerView.Adapter<CheckboxSimpleLeftViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxSimpleLeftViewHolder {
        return CheckboxSimpleLeftViewHolder(parent.inflate(R.layout.adapter_checkbox_simple_left, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxSimpleLeftViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}