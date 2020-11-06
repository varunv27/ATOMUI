package com.decouikit.atom.components.parallax.product.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.product.holder.FriendListViewHolder
import com.decouikit.atom.components.parallax.product.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.product.model.FriendListItem
import com.decouikit.atom.extensions.inflate

class FriendListAdapter(private var items: ArrayList<FriendListItem>) :
    RecyclerView.Adapter<FriendListViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendListViewHolder {
        return FriendListViewHolder(parent.inflate(R.layout.adapter_card_image, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: FriendListViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}