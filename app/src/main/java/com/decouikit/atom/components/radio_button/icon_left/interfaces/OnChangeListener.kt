package com.decouikit.atom.components.radio_button.icon_left.interfaces

import com.decouikit.atom.components.radio_button.icon_left.model.RadioButtonItem


interface OnChangeListener {
    fun onChangeListener(item: RadioButtonItem, isChanged: Boolean, position: Int)
}
