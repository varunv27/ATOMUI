package com.decouikit.atom.components.toggle.group.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToggleGroupItem(
    val title: String,
    val subItems: List<ToggleSimpleItem>? = arrayListOf()
) : Parcelable