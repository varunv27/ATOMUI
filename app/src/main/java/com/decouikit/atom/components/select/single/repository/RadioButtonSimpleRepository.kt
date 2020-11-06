package com.decouikit.atom.components.select.single.repository

import com.decouikit.atom.components.select.single.model.RadioButtonItem
import io.reactivex.Observable

object RadioButtonSimpleRepository {
    fun getData(): Observable<List<RadioButtonItem>> {
        val list = mutableListOf<RadioButtonItem>()
        list.add(RadioButtonItem("New York"))
        list.add(RadioButtonItem("Paris", isSelected = true))
        list.add(RadioButtonItem("Amsterdam"))
        list.add(RadioButtonItem("Gotham City"))
        return Observable.just(list)
    }
}