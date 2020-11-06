package com.decouikit.atom.components.lists.expandable.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExpandableSubItemView(
    val id: Int,
    val title: String? = "",
    val tagName: String? = "",
    @DrawableRes val tagBgRes: Int? = -1,
    val tagTextColor: Int? = -1,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1
) : Parcelable