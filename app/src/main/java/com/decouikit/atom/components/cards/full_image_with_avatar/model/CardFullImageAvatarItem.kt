package com.decouikit.atom.components.cards.full_image_with_avatar.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardFullImageAvatarItem(
    val title: String,
    val subtitle: String,
    var isLiked: Boolean = false,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
): Parcelable