package com.decouikit.atom.components.radio_button.simple_left.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.simple_left.holder.RadioButtonSimpleLeftViewHolder
import com.decouikit.atom.components.radio_button.simple_left.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.simple_left.model.RadioButtonItem
import com.decouikit.atom.extensions.inflate

class RadioButtonSimpleLeftAdapter(private var list: List<RadioButtonItem>) :
    RecyclerView.Adapter<RadioButtonSimpleLeftViewHolder>(), OnChangeListener {

    var onChangeListener: OnChangeListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RadioButtonSimpleLeftViewHolder {
        return RadioButtonSimpleLeftViewHolder(
            parent.inflate(
                R.layout.adapter_radio_simple_left,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: RadioButtonSimpleLeftViewHolder, position: Int) {
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