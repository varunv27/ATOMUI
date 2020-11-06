package com.decouikit.atom.components.toggle.group.repository

import android.content.Context
import com.decouikit.atom.components.toggle.group.model.ToggleGroupItem
import com.decouikit.atom.components.toggle.group.model.ToggleSimpleItem
import io.reactivex.Observable

object ToggleGroupRepository {

    fun getData(context: Context): Observable<List<ToggleGroupItem>> {
        val list = mutableListOf<ToggleGroupItem>()
        list.add(
            ToggleGroupItem(
                "Like Notifications",
                subItems = getSimpleData(context)
            )
        )
        list.add(
            ToggleGroupItem(
                "Comment Notifications",
                subItems = getSimpleData(context)
            )
        )
        return Observable.just(list)
    }

    private fun getSimpleData(context: Context): List<ToggleSimpleItem> {
        val list = mutableListOf<ToggleSimpleItem>()
        list.add(
            ToggleSimpleItem(
                "Allow members to search", isSelected = true
            )
        )
        list.add(
            ToggleSimpleItem(
                "Upcoming Classes", isSelected = false
            )
        )
        list.add(
            ToggleSimpleItem(
                "Favourite Classes", isSelected = true
            )
        )
        list.add(
            ToggleSimpleItem(
                "Enable Notifications", isSelected = false
            )
        )
        return list
    }
}