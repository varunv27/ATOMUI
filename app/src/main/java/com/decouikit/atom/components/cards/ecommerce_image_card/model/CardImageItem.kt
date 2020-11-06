package com.decouikit.atom.components.cards.ecommerce_image_card.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardImageItem(
    val title: String,
    val subtitle: String,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable