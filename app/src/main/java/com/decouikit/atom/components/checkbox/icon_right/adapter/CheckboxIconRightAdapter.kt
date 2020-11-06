package com.decouikit.atom.components.checkbox.icon_right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.icon_right.holder.CheckboxIconRightViewHolder
import com.decouikit.atom.components.checkbox.icon_right.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxIconRightAdapter(private var list: List<CheckBoxItem>)
    : RecyclerView.Adapter<CheckboxIconRightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxIconRightViewHolder {
        return CheckboxIconRightViewHolder(parent.inflate(R.layout.adapter_checkbox_image_right, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxIconRightViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}