package com.decouikit.atom.components.navigation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.holder.NavProfileViewHolder
import com.decouikit.atom.components.navigation.interfaces.OnProfileItemClickListener
import com.decouikit.atom.components.navigation.model.NavProfileItem
import com.decouikit.atom.extensions.inflate

class NavProfileAdapter(private var items: ArrayList<NavProfileItem>) :
    RecyclerView.Adapter<NavProfileViewHolder>() {

    private var listener: OnProfileItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavProfileViewHolder {
        return NavProfileViewHolder(parent.inflate(R.layout.adapter_card_styled_two, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: NavProfileViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setItemClickListener(listener: OnProfileItemClickListener?) {
        this.listener = listener
    }
}