package com.decouikit.atom.components.radio_button.simple_left.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.radio_button.simple_left.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.simple_left.model.RadioButtonItem
import kotlinx.android.synthetic.main.adapter_radio_simple_left.view.*

class RadioButtonSimpleLeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var item: RadioButtonItem
    private var listener: OnChangeListener? = null

    init {
        itemView.radiobutton.setOnClickListener {
            listener?.onChangeListener(item, !item.isSelected, adapterPosition)
        }
    }

    fun bind(item: RadioButtonItem, listener: OnChangeListener) {
        this.item = item
        this.listener = listener
        itemView.radiobutton.isChecked = item.isSelected
        itemView.radiobutton.text = item.title
    }
}