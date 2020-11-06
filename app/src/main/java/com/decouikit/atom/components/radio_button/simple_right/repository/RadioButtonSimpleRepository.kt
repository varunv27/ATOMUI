package com.decouikit.atom.components.radio_button.simple_right.repository

import android.content.Context
import com.decouikit.atom.components.radio_button.simple_right.model.RadioButtonItem
import io.reactivex.Observable

object RadioButtonSimpleRepository {
    fun getData(context: Context) : Observable<List<RadioButtonItem>> {
        val list = mutableListOf<RadioButtonItem>()
        list.add(RadioButtonItem("Paris"))
        list.add(RadioButtonItem("Alabama"))
        list.add(RadioButtonItem("Brooklyn"))
        list.add(RadioButtonItem("Chelsea"))
        list.add(RadioButtonItem("Florence"))
        list.add(RadioButtonItem("Ireland"))
        return Observable.just(list)
    }
}