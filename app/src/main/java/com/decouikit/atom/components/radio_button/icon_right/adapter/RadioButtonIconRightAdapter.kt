package com.decouikit.atom.components.radio_button.icon_right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.icon_right.holder.RadioButtonIconRightViewHolder
import com.decouikit.atom.components.radio_button.icon_right.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.icon_right.model.RadioButtonItem
import com.decouikit.atom.extensions.inflate

class RadioButtonIconRightAdapter(private var list: List<RadioButtonItem>)
    : RecyclerView.Adapter<RadioButtonIconRightViewHolder>(), OnChangeListener {

    var onChangeListener: OnChangeListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioButtonIconRightViewHolder {
        return RadioButtonIconRightViewHolder(parent.inflate(R.layout.adapter_radio_image_right, false))
    }

    override fun onBindViewHolder(viewHolder: RadioButtonIconRightViewHolder, position: Int) {
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