package com.decouikit.atom.components.parallax.shopping.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.shopping.holder.ShoppingViewHolder
import com.decouikit.atom.components.parallax.shopping.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.shopping.model.ShoppingItem
import com.decouikit.atom.extensions.inflate

class ShoppingAdapter(private var items: ArrayList<ShoppingItem>) :
    RecyclerView.Adapter<ShoppingViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(parent.inflate(R.layout.adapter_parallax_shopping_item, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}