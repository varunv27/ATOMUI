package com.decouikit.atom.components.search.top_bar.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SearchTopBarBaseItem(
    val searchPlaceholder: String? = "",
    val viewItems: List<SearchTopBarItem>? = arrayListOf()
) : Parcelable