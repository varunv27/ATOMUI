package com.decouikit.atom.components.parallax.profile.interfaces

import com.decouikit.atom.components.parallax.profile.model.ProfileListItem

interface OnItemClickListener {
    fun onItemClick(item: ProfileListItem)
    fun onCommentsClick()
}