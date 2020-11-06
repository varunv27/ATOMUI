package com.decouikit.atom.components.radio_button.icon_right.interfaces

import com.decouikit.atom.components.radio_button.icon_right.model.RadioButtonItem


interface OnChangeListener {
    fun onChangeListener(item: RadioButtonItem, isChanged: Boolean, position: Int)
}
