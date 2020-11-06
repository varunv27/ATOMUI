package com.decouikit.atom.components.cards.styled.interfaces

import com.decouikit.atom.components.cards.styled.model.StyledCardItem

interface OnItemClickListener {
    fun onItemClick(item: StyledCardItem)
    fun onCommentsClick()
}