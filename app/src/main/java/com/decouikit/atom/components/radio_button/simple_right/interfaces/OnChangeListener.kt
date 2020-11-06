package com.decouikit.atom.components.radio_button.simple_right.interfaces

import com.decouikit.atom.components.radio_button.simple_right.model.RadioButtonItem


interface OnChangeListener {
    fun onChangeListener(item: RadioButtonItem, isChanged: Boolean, position: Int)
}
