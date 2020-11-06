package com.decouikit.atom.components.search.top_bar.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class SearchTopBarItem(
    val title: String,
    val subtitle: String,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1
) : Parcelable