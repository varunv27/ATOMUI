package com.decouikit.atom.components.toggle.description.repository

import android.content.Context
import com.decouikit.atom.components.toggle.description.model.ToggleDescItem
import io.reactivex.Observable

object ToggleDescRepository {
    fun getData(context: Context) : Observable<List<ToggleDescItem>> {
        val list = mutableListOf<ToggleDescItem>()
        list.add(ToggleDescItem(
            "Allow members to search",
            "Lorem ipsum dolor sit amet, eget consectetur adipiscing elit, sed id.",
            isSelected = true
        ))
        list.add(ToggleDescItem(
            "Upcoming Classes",
            "Lorem ipsum dolor sit amet, eget consectetur adipiscing elit, sed id.",
            isSelected = false
        ))
        list.add(ToggleDescItem(
            "Favourite Classes",
            "Lorem ipsum dolor sit amet, eget consectetur adipiscing elit, sed id.",
            isSelected = true
        ))
        list.add(ToggleDescItem(
            "Enable Notifications",
            "Lorem ipsum dolor sit amet, eget consectetur adipiscing elit, sed id.",
            isSelected = false
        ))
        return Observable.just(list)
    }
}