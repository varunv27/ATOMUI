package com.decouikit.atom.components.radio_button.simple_right.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.radio_button.simple_right.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.simple_right.model.RadioButtonItem
import kotlinx.android.synthetic.main.adapter_radio_simple_right.view.*

class RadioButtonSimpleRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private lateinit var item: RadioButtonItem
    private var listener: OnChangeListener? = null

    init {
        itemView.radioParent.setOnClickListener(this)
    }

    fun bind(item: RadioButtonItem, listener: OnChangeListener) {
        this.item = item
        this.listener = listener
        itemView.radiobutton.isChecked = item.isSelected
        itemView.tvTitle.text = item.title
    }

    override fun onClick(v: View?) {
        item.isSelected = !item.isSelected
        listener?.onChangeListener(item, !item.isSelected, adapterPosition)
    }
}