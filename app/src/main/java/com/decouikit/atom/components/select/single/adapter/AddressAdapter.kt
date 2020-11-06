package com.decouikit.atom.components.select.single.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.select.single.holder.AddressViewHolder
import com.decouikit.atom.components.select.single.interfaces.OnAddressItemClickListener
import com.decouikit.atom.extensions.inflate

class AddressAdapter(private var list: List<String>, private val listener: OnAddressItemClickListener)
    : RecyclerView.Adapter<AddressViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        return AddressViewHolder(parent.inflate(R.layout.adapter_address_item, false))
    }

    override fun onBindViewHolder(viewHolder: AddressViewHolder, position: Int) {
        viewHolder.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}