package com.decouikit.atom.components.cards.social_thumb.interfaces

import com.decouikit.atom.components.cards.social_thumb.model.SocialThumbItem


interface OnItemClickListener {
    fun onItemClick(item: SocialThumbItem)
    fun onCommentsClick()
}