package com.decouikit.atom.components.toggle.description.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToggleDescItem(val title: String, val desc: String, var isSelected: Boolean = false) :
    Parcelable