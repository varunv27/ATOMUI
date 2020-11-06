package com.decouikit.atom.components.toggle.simple.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToggleSimpleItem(
    val title: String, var isSelected: Boolean = false
) : Parcelable