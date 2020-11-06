package com.decouikit.atom.components.select.single.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.select.single.interfaces.OnAddressItemClickListener
import kotlinx.android.synthetic.main.adapter_address_item.view.*

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private lateinit var item: String
    private var onAddressItemClickListener: OnAddressItemClickListener? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: String, onAddressItemClickListener: OnAddressItemClickListener?) {
        this.item = item
        this.onAddressItemClickListener = onAddressItemClickListener
        itemView.tvAddress.text = item
    }

    override fun onClick(v: View?) {
        onAddressItemClickListener?.onAddressItemClick(item)
    }
}