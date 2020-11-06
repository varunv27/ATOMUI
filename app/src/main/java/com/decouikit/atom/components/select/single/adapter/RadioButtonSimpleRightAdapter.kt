package com.decouikit.atom.components.select.single.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.select.single.holder.RadioButtonSimpleRightViewHolder
import com.decouikit.atom.components.select.single.interfaces.OnChangeListener
import com.decouikit.atom.components.select.single.interfaces.OnSelectDialogListener
import com.decouikit.atom.components.select.single.model.RadioButtonItem
import com.decouikit.atom.extensions.inflate

class RadioButtonSimpleRightAdapter(private var onSelectDialogListener: OnSelectDialogListener)
    : RecyclerView.Adapter<RadioButtonSimpleRightViewHolder>(), OnChangeListener {

    var list: List<RadioButtonItem>? = null
    var onChangeListener: OnChangeListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioButtonSimpleRightViewHolder {
        return RadioButtonSimpleRightViewHolder(parent.inflate(R.layout.adapter_radio_simple_right, false))
    }

    override fun onBindViewHolder(viewHolder: RadioButtonSimpleRightViewHolder, position: Int) {
        viewHolder.bind(list?.get(position)!!, this)
    }

    override fun getItemCount(): Int {
        return list?.size?: 0
    }

    fun setItems(items: List<RadioButtonItem>) {
        this.list = items
        notifyDataSetChanged()
    }

    override fun onChangeListener(item: RadioButtonItem, isChanged: Boolean, position: Int) {
        list?.forEachIndexed { index, element -> element.isSelected = index == position }
        notifyDataSetChanged()
        onChangeListener?.onChangeListener(item, isChanged, position)
        onSelectDialogListener.onSelectDialogItem(item)
    }
}