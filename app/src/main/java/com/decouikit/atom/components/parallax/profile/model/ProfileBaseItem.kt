package com.decouikit.atom.components.parallax.profile.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileBaseItem(
    val title: String,
    val subtitle: String,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1,
    val button1Text: String,
    val button2Text: String,
    val viewItems: List<ProfileListItem>? = arrayListOf()
) : Parcelable