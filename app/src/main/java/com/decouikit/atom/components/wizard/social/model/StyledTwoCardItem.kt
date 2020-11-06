package com.decouikit.atom.components.wizard.social.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StyledTwoCardItem(
    val title: String,
    val subtitle: String,
    val name: String,
    val articles: String,
    var isFollowing: Boolean = true,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1,
    val backgroundPhotoUrl: String? = "",
    @DrawableRes val backgroundPhotoDrawableRes: Int? = -1
) : Parcelable