package com.decouikit.atom.components.navigation.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NavBlogItem(
    val title: String,
    val subtitle: String,
    val comments: Int,
    val likes: Int,
    var isLiked: Boolean = false,
    @ColorRes val colorBg: Int? = -1
) : Parcelable