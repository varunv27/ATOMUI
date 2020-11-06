package com.decouikit.atom.components.search.simple.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchSimpleBaseItem(
    val searchPlaceholder: String? = "",
    val viewItems: List<SearchSimpleItem>? = arrayListOf()
) : Parcelable