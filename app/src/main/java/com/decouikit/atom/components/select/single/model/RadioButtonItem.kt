package com.decouikit.atom.components.select.single.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RadioButtonItem(
    val title: String,
    val imageUrl: String? = "",
    @DrawableRes val imageDrawableRes: Int? = -1,
    var isSelected: Boolean = false
) : Parcelable