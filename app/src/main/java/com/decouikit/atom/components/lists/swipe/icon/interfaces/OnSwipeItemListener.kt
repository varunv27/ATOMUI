package com.decouikit.atom.components.lists.swipe.icon.interfaces

import android.view.View
import com.decouikit.atom.components.lists.swipe.icon.model.SwipeViewItem

interface OnSwipeItemListener {
    fun onItemPinned(position: Int)
    fun removeItem(view: View, item: SwipeViewItem, position: Int)
    fun addItem(view: View, item: SwipeViewItem, position: Int)
    fun onItemClick(item: SwipeViewItem)
}