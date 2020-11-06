package com.decouikit.atom.components.lists.expandable.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ExpandableViewItem(
    val id: Int,
    val title: String,
    val subItems: List<ExpandableSubItemView>? = arrayListOf()
) : Parcelable