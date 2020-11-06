package com.decouikit.atom.components.navigation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.holder.NavProductViewHolder
import com.decouikit.atom.components.navigation.interfaces.OnProductItemClickListener
import com.decouikit.atom.components.navigation.model.NavProductItem
import com.decouikit.atom.extensions.inflate

class NavProductAdapter(private var items: ArrayList<NavProductItem>) :
    RecyclerView.Adapter<NavProductViewHolder>() {

    private var listener: OnProductItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavProductViewHolder {
        return NavProductViewHolder(parent.inflate(R.layout.adapter_card_shopping_cart, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: NavProductViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setItemClickListener(listener: OnProductItemClickListener?) {
        this.listener = listener
    }
}