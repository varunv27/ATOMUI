package com.decouikit.atom.components.checkbox.simple_right.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class CheckBoxItem(
    val title: String,
    val imageUrl: String? = "",
    @DrawableRes val imageDrawableRes: Int? = -1,
    var isSelected: Boolean = false
) : Parcelable