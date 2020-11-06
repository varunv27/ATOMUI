package com.decouikit.atom.components.radio_button.simple_right.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.simple_right.holder.RadioButtonSimpleRightViewHolder
import com.decouikit.atom.components.radio_button.simple_right.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.simple_right.model.RadioButtonItem
import com.decouikit.atom.extensions.inflate

class RadioButtonSimpleRightAdapter(private var list: List<RadioButtonItem>) :
    RecyclerView.Adapter<RadioButtonSimpleRightViewHolder>(), OnChangeListener {

    var onChangeListener: OnChangeListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RadioButtonSimpleRightViewHolder {
        return RadioButtonSimpleRightViewHolder(
            parent.inflate(
                R.layout.adapter_radio_simple_right,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: RadioButtonSimpleRightViewHolder, position: Int) {
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