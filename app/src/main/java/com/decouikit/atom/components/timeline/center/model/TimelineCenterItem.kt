package com.decouikit.atom.components.timeline.center.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimelineCenterItem(
    val title: String,
    val subtitle: String,
    val position: TimelineType,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1
) : Parcelable