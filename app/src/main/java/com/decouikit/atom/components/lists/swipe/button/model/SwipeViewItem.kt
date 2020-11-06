package com.decouikit.atom.components.lists.swipe.button.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SwipeViewItem(
    val id: Int,
    val title: String,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1,
    var isPinned: Boolean = false
) : Parcelable