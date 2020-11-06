package com.decouikit.atom.components.navigation.interfaces

import com.decouikit.atom.components.navigation.model.NavBlogItem


interface OnBlogItemClickListener {
    fun onItemClick(item: NavBlogItem)
    fun onCommentsClick()
}