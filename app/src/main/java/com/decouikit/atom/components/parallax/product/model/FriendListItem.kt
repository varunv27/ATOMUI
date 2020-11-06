package com.decouikit.atom.components.parallax.product.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class FriendListItem(
    val title: String,
    val subtitle: String,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes
    val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable