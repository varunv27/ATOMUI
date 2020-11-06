package com.decouikit.atom.components.lists.swipe.button.interfaces

import android.view.View
import com.decouikit.atom.components.lists.swipe.button.model.SwipeViewItem

interface OnSwipeItemListener {
    fun onItemPinned(position: Int)
    fun onItemButtonClick(view: View, item: SwipeViewItem, position: Int)
    fun onItemClick(item: SwipeViewItem)
}