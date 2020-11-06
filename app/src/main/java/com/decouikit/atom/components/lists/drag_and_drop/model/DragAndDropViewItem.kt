package com.decouikit.atom.components.lists.drag_and_drop.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DragAndDropViewItem(
    val id: Int,
    val title: String,
    val avatarUrl: String? = "",
    @DrawableRes val avatarDrawableRes: Int? = -1
) : Parcelable