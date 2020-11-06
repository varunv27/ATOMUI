package com.decouikit.atom.components.cards.styled_2.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StyledTwoCardItem(
    val title: String,
    val subtitle: String,
    val name: String,
    val articles: String,
    val avatarUrl: String? = "",
    var isFollowing: Boolean = true,
    @DrawableRes val avatarDrawableRes: Int? = -1,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
):Parcelable