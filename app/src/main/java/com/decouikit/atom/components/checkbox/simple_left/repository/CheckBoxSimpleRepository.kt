package com.decouikit.atom.components.checkbox.simple_left.repository

import android.content.Context
import com.decouikit.atom.components.checkbox.simple_left.model.CheckBoxItem
import io.reactivex.Observable

object CheckBoxSimpleRepository {
    fun getData(context: Context) : Observable<List<CheckBoxItem>> {
        val list = mutableListOf<CheckBoxItem>()
        list.add(CheckBoxItem("Paris"))
        list.add(CheckBoxItem("Alabama"))
        list.add(CheckBoxItem("Brooklyn"))
        list.add(CheckBoxItem("Chelsea"))
        list.add(CheckBoxItem("Florence"))
        list.add(CheckBoxItem("Ireland"))
        return Observable.just(list)
    }
}