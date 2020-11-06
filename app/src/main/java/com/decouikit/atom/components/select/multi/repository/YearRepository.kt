package com.decouikit.atom.components.select.multi.repository

import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import io.reactivex.Observable

object YearRepository {
    fun getData(): Observable<List<CheckBoxItem>> {
        val list = mutableListOf<CheckBoxItem>()
        list.add(CheckBoxItem("2009", isSelected = true))
        list.add(CheckBoxItem("2010"))
        list.add(CheckBoxItem("2011"))
        list.add(CheckBoxItem("2012"))
        list.add(CheckBoxItem("2013"))
        list.add(CheckBoxItem("2014"))
        list.add(CheckBoxItem("2015"))
        list.add(CheckBoxItem("2016"))
        list.add(CheckBoxItem("2017"))
        list.add(CheckBoxItem("2018"))
        list.add(CheckBoxItem("2019"))
        list.add(CheckBoxItem("2020"))
        return Observable.just(list)
    }
}