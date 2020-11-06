package com.decouikit.atom.components.toggle.simple.repository

import android.content.Context
import com.decouikit.atom.components.toggle.simple.model.ToggleSimpleItem
import io.reactivex.Observable

object ToggleSimpleRepository {
    fun getData(context: Context) : Observable<List<ToggleSimpleItem>> {
        val list = mutableListOf<ToggleSimpleItem>()
        list.add(ToggleSimpleItem(
            "Allow members to search", isSelected = true
        ))
        list.add(ToggleSimpleItem(
            "Upcoming Classes", isSelected = false
        ))
        list.add(ToggleSimpleItem(
            "Favourite Classes", isSelected = true
        ))
        list.add(ToggleSimpleItem(
            "Enable Notifications", isSelected = false
        ))
        return Observable.just(list)
    }
}