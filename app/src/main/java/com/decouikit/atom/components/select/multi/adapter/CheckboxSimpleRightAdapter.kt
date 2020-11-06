package com.decouikit.atom.components.select.multi.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.select.multi.holder.CheckboxSimpleRightViewHolder
import com.decouikit.atom.components.select.multi.interfaces.OnChangeListener
import com.decouikit.atom.components.select.multi.interfaces.OnSelectDialogListener
import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import com.decouikit.atom.extensions.inflate

class CheckboxSimpleRightAdapter(private var onSelectDialogListener: OnSelectDialogListener)
    : RecyclerView.Adapter<CheckboxSimpleRightViewHolder>(), OnChangeListener {

    private var list: List<CheckBoxItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckboxSimpleRightViewHolder {
        return CheckboxSimpleRightViewHolder(parent.inflate(R.layout.adapter_checkbox_simple_right, false))
    }

    override fun onBindViewHolder(viewHolder: CheckboxSimpleRightViewHolder, position: Int) {
        viewHolder.bind(list?.get(position)!!, this)
    }

    override fun getItemCount(): Int {
        return list?.size?: 0
    }

    fun setItems(items: List<CheckBoxItem>) {
        this.list = items
        notifyDataSetChanged()
    }

    override fun onChangeListener(item: CheckBoxItem, isChecked: Boolean, position: Int) {
        item.isSelected = isChecked
        notifyItemChanged(position)
        list?.let { onSelectDialogListener.onSelectDialogItem(it) }
    }
}