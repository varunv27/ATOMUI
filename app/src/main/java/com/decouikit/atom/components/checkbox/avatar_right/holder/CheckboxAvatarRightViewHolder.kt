package com.decouikit.atom.components.checkbox.avatar_right.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.checkbox.avatar_right.model.CheckBoxItem
import kotlinx.android.synthetic.main.adapter_checkbox_image_right.view.*

class CheckboxAvatarRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private lateinit var item: CheckBoxItem

    init {
        itemView.checkboxParent.setOnClickListener(this)
    }

    fun bind(item: CheckBoxItem) {
        this.item = item
        itemView.tvTitle.text = item.title
        itemView.ivAvatar.setImageDrawable(item.imageDrawableRes?.let {
            ContextCompat.getDrawable(itemView.context,
                it
            )
        })
    }

    override fun onClick(v: View?) {
        item.isSelected = !item.isSelected
        itemView.checkbox.isChecked = item.isSelected
    }
}