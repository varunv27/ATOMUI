package com.decouikit.atom.components.cards.social_thumb.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class SocialThumbItem(
    val title: String,
    val subtitle: String,
    val comments: Int,
    val likes: Int,
    var isLiked: Boolean = false,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes
    val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable
