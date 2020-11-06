package com.decouikit.atom.components.search.simple.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchSimpleItem(
    val title: String,
    val subtitle: String,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1
) : Parcelable