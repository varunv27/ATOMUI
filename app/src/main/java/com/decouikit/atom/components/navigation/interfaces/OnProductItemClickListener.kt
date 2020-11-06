package com.decouikit.atom.components.navigation.interfaces

import com.decouikit.atom.components.navigation.model.NavProductItem

interface OnProductItemClickListener {
    fun onItemClick(item: NavProductItem)
    fun onAddClick(item: NavProductItem)
    fun onRemoveClick(item: NavProductItem)
}