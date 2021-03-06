package com.decouikit.atom.components.radio_button.icon_right.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.radio_button.icon_right.interfaces.OnChangeListener
import com.decouikit.atom.components.radio_button.icon_right.model.RadioButtonItem
import kotlinx.android.synthetic.main.adapter_radio_image_right.view.*

class RadioButtonIconRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private lateinit var item: RadioButtonItem
    private var listener: OnChangeListener? = null

    init {
        itemView.radioParent.setOnClickListener(this)
    }

    fun bind(item: RadioButtonItem, listener: OnChangeListener?) {
        this.item = item
        this.listener = listener
        itemView.radiobutton.isChecked = item.isSelected
        itemView.tvTitle.text = item.title
        itemView.ivAvatar.setImageDrawable(item.imageDrawableRes?.let {
            ContextCompat.getDrawable(
                itemView.context,
                it
            )
        })
    }

    override fun onClick(v: View?) {
        item.isSelected = !item.isSelected
        listener?.onChangeListener(item, !item.isSelected, adapterPosition)
    }
}