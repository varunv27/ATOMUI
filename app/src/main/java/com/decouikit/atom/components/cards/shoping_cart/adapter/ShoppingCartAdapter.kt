package com.decouikit.atom.components.cards.shoping_cart.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.shoping_cart.holder.ShoppingCartViewHolder
import com.decouikit.atom.components.cards.shoping_cart.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.shoping_cart.model.ShoppingCartItem
import com.decouikit.atom.extensions.inflate

class ShoppingCartAdapter(private var items: ArrayList<ShoppingCartItem>) :
    RecyclerView.Adapter<ShoppingCartViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingCartViewHolder {
        return ShoppingCartViewHolder(parent.inflate(R.layout.adapter_card_shopping_cart, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ShoppingCartViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}