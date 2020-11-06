package com.decouikit.atom.components.wizard.profile.interfaces

import com.decouikit.atom.components.wizard.profile.model.StyledCardItem


interface OnItemClickListener {
    fun onItemClick(item: StyledCardItem)
    fun onCommentsClick()
}