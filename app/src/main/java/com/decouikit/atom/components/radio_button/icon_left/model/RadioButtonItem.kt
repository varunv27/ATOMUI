package com.decouikit.atom.components.radio_button.icon_left.model

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