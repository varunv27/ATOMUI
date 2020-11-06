package com.decouikit.atom.components.checkbox.avatar_right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.avatar_right.holder.CheckboxAvatarRightViewHolder
import com.decouikit.atom.components.checkbox.avatar_right.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxAvatarRightAdapter(private var list: List<CheckBoxItem>)
    : RecyclerView.Adapter<CheckboxAvatarRightViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxAvatarRightViewHolder {
        return CheckboxAvatarRightViewHolder(parent.inflate(R.layout.adapter_checkbox_image_right, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxAvatarRightViewHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}