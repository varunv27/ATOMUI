package com.decouikit.atom.components.parallax.product.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FriendsItem(
    val title: String,
    val subtitle: String,
    val tagName: String,
    val description: String,
    val buttonText: String,
    val viewItems: List<FriendListItem>? = arrayListOf()
) : Parcelable