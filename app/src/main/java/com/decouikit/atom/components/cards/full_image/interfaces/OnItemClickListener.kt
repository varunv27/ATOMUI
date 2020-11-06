package com.decouikit.atom.components.cards.full_image.interfaces

import com.decouikit.atom.components.cards.full_image.model.CardFullImageItem


interface OnItemClickListener {
    fun onItemClick(item: CardFullImageItem)
    fun onCommentsClick()
}