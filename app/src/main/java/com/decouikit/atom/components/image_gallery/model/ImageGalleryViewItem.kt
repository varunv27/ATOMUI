package com.decouikit.atom.components.image_gallery.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageGalleryViewItem(
    val title: String? = "",
    val subtitle: String? = "",
    val image: String? = "",
    @DrawableRes val imageDrawableRes: Int? = -1,
    val imageViews: List<ImageGalleryViewItem>? = arrayListOf()
) : Parcelable