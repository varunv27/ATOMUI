package com.decouikit.atom.components.select.multi.repository

import android.content.Context
import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import io.reactivex.Observable

object CountryRepository {
    fun getData(context: Context) : Observable<List<CheckBoxItem>> {
        val list = mutableListOf<CheckBoxItem>()
        list.add(CheckBoxItem("USA", isSelected = true))
        list.add(CheckBoxItem("France"))
        list.add(CheckBoxItem("Netherlands"))
        list.add(CheckBoxItem("Gotham Land"))
        return Observable.just(list)
    }
}