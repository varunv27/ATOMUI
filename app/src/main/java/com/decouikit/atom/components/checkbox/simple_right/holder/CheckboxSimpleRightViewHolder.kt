package com.decouikit.atom.components.checkbox.simple_right.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.checkbox.simple_right.model.CheckBoxItem
import kotlinx.android.synthetic.main.adapter_checkbox_simple_right.view.*

class CheckboxSimpleRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private lateinit var item: CheckBoxItem

    init {
        itemView.checkboxParent.setOnClickListener(this)
    }

    fun bind(item: CheckBoxItem) {
        this.item = item
        itemView.tvTitle.text = item.title
    }

    override fun onClick(v: View?) {
        item.isSelected = !item.isSelected
        itemView.checkbox.isChecked = item.isSelected
    }
}