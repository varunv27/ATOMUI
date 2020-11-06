package com.decouikit.atom.components.select.multi.interfaces

import com.decouikit.atom.components.select.multi.model.CheckBoxItem


interface OnChangeListener {
    fun onChangeListener(item: CheckBoxItem, isChecked: Boolean, position: Int)
}
