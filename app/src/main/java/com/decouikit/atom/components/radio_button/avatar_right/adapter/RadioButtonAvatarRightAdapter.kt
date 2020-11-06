package com.decouikit.atom.components.radio_button.avatar_right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.avatar_right.holder.RadioButtonAvatarRightViewHolder
import com.decouikit.atom.components.radio_button.avatar_right.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.avatar_right.model.RadioButtonItem
import com.decouikit.atom.extensions.inflate

class RadioButtonAvatarRightAdapter(private var list: List<RadioButtonItem>)
    : RecyclerView.Adapter<RadioButtonAvatarRightViewHolder>(), OnChangeListener {

    var onChangeListener: OnChangeListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioButtonAvatarRightViewHolder {
        return RadioButtonAvatarRightViewHolder(parent.inflate(R.layout.adapter_radio_image_right, false))
    }

    override fun onBindViewHolder(viewHolder: RadioButtonAvatarRightViewHolder, position: Int) {
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