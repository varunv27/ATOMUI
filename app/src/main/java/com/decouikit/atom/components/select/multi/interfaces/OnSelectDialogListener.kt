package com.decouikit.atom.components.select.multi.interfaces

import com.decouikit.atom.components.select.multi.model.CheckBoxItem


interface OnSelectDialogListener {
    fun onSelectDialogItem(items: List<CheckBoxItem>)
}