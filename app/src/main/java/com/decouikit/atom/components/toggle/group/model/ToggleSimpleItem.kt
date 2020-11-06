package com.decouikit.atom.components.toggle.group.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToggleSimpleItem(
    val title: String, var isSelected: Boolean = false
): Parcelable