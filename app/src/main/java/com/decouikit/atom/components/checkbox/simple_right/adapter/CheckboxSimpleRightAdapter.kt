package com.decouikit.atom.components.checkbox.simple_right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.simple_right.holder.CheckboxSimpleRightViewHolder
import com.decouikit.atom.components.checkbox.simple_right.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxSimpleRightAdapter(private var list: List<CheckBoxItem>)
    : RecyclerView.Adapter<CheckboxSimpleRightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxSimpleRightViewHolder {
        return CheckboxSimpleRightViewHolder(parent.inflate(R.layout.adapter_checkbox_simple_right, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxSimpleRightViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}