package com.decouikit.atom.components.cards.social_color_card.interfaces

import com.decouikit.atom.components.cards.social_color_card.model.CardColorItem


interface OnItemClickListener {
    fun onItemClick(item: CardColorItem)
    fun onCommentsClick()
}