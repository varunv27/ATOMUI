package com.decouikit.atom.components.select.multi.repository

import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import io.reactivex.Observable

object MonthRepository {
    fun getData(): Observable<List<CheckBoxItem>> {
        val list = mutableListOf<CheckBoxItem>()
        list.add(CheckBoxItem("January", isSelected = true))
        list.add(CheckBoxItem("February"))
        list.add(CheckBoxItem("March"))
        list.add(CheckBoxItem("April"))
        list.add(CheckBoxItem("May"))
        list.add(CheckBoxItem("June"))
        list.add(CheckBoxItem("July"))
        list.add(CheckBoxItem("August"))
        list.add(CheckBoxItem("September"))
        list.add(CheckBoxItem("October"))
        list.add(CheckBoxItem("November"))
        list.add(CheckBoxItem("December"))
        return Observable.just(list)
    }
}