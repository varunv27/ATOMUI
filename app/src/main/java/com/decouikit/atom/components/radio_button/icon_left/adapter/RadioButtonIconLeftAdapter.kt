package com.decouikit.atom.components.radio_button.icon_left.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.icon_left.holder.RadioButtonIconLeftViewHolder
import com.decouikit.atom.components.radio_button.icon_left.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.icon_left.model.RadioButtonItem
import com.decouikit.atom.extensions.inflate

class RadioButtonIconLeftAdapter(private var list: List<RadioButtonItem>)
    : RecyclerView.Adapter<RadioButtonIconLeftViewHolder>(), OnChangeListener {

    var onChangeListener: OnChangeListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioButtonIconLeftViewHolder {
        return RadioButtonIconLeftViewHolder(parent.inflate(R.layout.adapter_radio_image_left, false))
    }

    override fun onBindViewHolder(viewHolder: RadioButtonIconLeftViewHolder, position: Int) {
        viewHolder.bind(list[position], this)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onChangeListener(item: RadioButtonItem, isChanged: Boolean, position: Int) {
        list.forEachIndexed { index, element -> element.isSelected = index == position }
        notifyDataSetChanged()
        onChangeListener?.onChangeListener(item, isChanged, position)
    }
}