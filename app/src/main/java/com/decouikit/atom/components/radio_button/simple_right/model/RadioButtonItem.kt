package com.decouikit.atom.components.radio_button.simple_right.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class RadioButtonItem(
    val title: String,
    val imageUrl: String? = "",
    @DrawableRes val imageDrawableRes: Int? = -1,
    var isSelected: Boolean = false
) : Parcelable