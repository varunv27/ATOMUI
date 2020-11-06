package com.decouikit.atom.components.search.top_bar.interfaces

import com.decouikit.atom.components.search.top_bar.model.SearchTopBarItem

interface OnItemClickListener {
    fun onItemClick(item: SearchTopBarItem)
}