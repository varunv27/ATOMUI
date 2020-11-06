package com.decouikit.atom.components.cards.shoping_cart.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoppingCartItem(
    val title: String,
    val subtitle: String,
    var size: Int,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable