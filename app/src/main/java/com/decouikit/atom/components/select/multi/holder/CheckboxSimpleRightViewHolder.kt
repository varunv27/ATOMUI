package com.decouikit.atom.components.select.multi.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.select.multi.interfaces.OnChangeListener
import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import kotlinx.android.synthetic.main.adapter_checkbox_simple_right.view.*

class CheckboxSimpleRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private lateinit var item: CheckBoxItem
    private var listener: OnChangeListener? = null

    init {
        itemView.checkboxParent.setOnClickListener(this)
        itemView.checkbox.setOnClickListener(this)

    }

    fun bind(item: CheckBoxItem, listener: OnChangeListener) {
        this.item = item
        this.listener = listener
        itemView.tvTitle.text = item.title
        itemView.checkbox.isChecked = item.isSelected
    }

    override fun onClick(v: View?) {
        when(v) {
            itemView.checkboxParent -> {
                item.isSelected = !item.isSelected
                itemView.checkbox.isChecked = item.isSelected
                listener?.onChangeListener(item, item.isSelected, adapterPosition)
            }
            itemView.checkbox -> {
                listener?.onChangeListener(item, !item.isSelected, adapterPosition)
            }
        }
    }
}