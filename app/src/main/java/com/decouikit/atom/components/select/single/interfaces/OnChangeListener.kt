package com.decouikit.atom.components.select.single.interfaces

import com.decouikit.atom.components.select.single.model.RadioButtonItem


interface OnChangeListener {
    fun onChangeListener(item: RadioButtonItem, isChanged: Boolean, position: Int)
}
