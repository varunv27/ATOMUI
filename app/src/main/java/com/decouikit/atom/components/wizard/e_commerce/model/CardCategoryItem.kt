package com.decouikit.atom.components.wizard.e_commerce.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardCategoryItem(
    val title: String,
    val subtitle: String,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable