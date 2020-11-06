package com.decouikit.atom.components.cards.ecommerce_thumb.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_thumb.holder.ThumbViewHolder
import com.decouikit.atom.components.cards.ecommerce_thumb.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_thumb.model.ThumbItem
import com.decouikit.atom.extensions.inflate

class ThumbAdapter(private var items: ArrayList<ThumbItem>) :
    RecyclerView.Adapter<ThumbViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThumbViewHolder {
        return ThumbViewHolder(parent.inflate(R.layout.adapter_parallax_shopping_item, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ThumbViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}