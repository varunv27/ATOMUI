package com.decouikit.atom.components.checkbox.avatar_left.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.avatar_left.holder.CheckboxAvatarLeftViewHolder
import com.decouikit.atom.components.checkbox.avatar_left.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxAvatarLeftAdapter(private var list: List<CheckBoxItem>)
    : RecyclerView.Adapter<CheckboxAvatarLeftViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxAvatarLeftViewHolder {
        return CheckboxAvatarLeftViewHolder(parent.inflate(R.layout.adapter_checkbox_image_left, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxAvatarLeftViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}