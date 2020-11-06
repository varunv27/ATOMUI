package com.decouikit.atom.components.cards.ecommerce_thumb.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class ThumbItem(
    val title: String,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable