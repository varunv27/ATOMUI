package com.decouikit.atom.components.cards.shoping_cart.interfaces

import com.decouikit.atom.components.cards.shoping_cart.model.ShoppingCartItem

interface OnItemClickListener {
    fun onItemClick(item: ShoppingCartItem)
    fun onAddClick(item: ShoppingCartItem)
    fun onRemoveClick(item: ShoppingCartItem)
}