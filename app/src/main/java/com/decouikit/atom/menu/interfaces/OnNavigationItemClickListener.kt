package com.decouikit.atom.menu.interfaces

import android.view.View
import com.decouikit.atom.menu.model.NavigationItem

interface OnNavigationItemClickListener {
    fun onNavigationItemClick(view: View, item: NavigationItem)
}