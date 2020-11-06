package com.decouikit.atom.components.checkbox.icon_left.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.icon_left.model.CheckBoxItem
import io.reactivex.Observable

object CheckBoxImageRepository {
    fun getData(context: Context) : Observable<List<CheckBoxItem>> {
        val list = mutableListOf<CheckBoxItem>()
        list.add(CheckBoxItem("Paris", imageDrawableRes = R.drawable.ic_icon_1))
        list.add(CheckBoxItem("Alabama", imageDrawableRes = R.drawable.ic_icon_2))
        list.add(CheckBoxItem("Brooklyn", imageDrawableRes = R.drawable.ic_icon_3))
        list.add(CheckBoxItem("Chelsea", imageDrawableRes = R.drawable.ic_icon_4))
        list.add(CheckBoxItem("Florence", imageDrawableRes = R.drawable.ic_icon_1))
        list.add(CheckBoxItem("Ireland", imageDrawableRes = R.drawable.ic_icon_2))
        return Observable.just(list)
    }
}