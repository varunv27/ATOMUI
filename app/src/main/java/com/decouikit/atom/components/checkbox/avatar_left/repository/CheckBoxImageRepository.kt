package com.decouikit.atom.components.checkbox.avatar_left.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.avatar_left.model.CheckBoxItem
import io.reactivex.Observable

object CheckBoxImageRepository {
    fun getData(context: Context) : Observable<List<CheckBoxItem>> {
        val list = mutableListOf<CheckBoxItem>()
        list.add(CheckBoxItem("Paris", imageDrawableRes = R.drawable.avatar_1))
        list.add(CheckBoxItem("Alabama", imageDrawableRes = R.drawable.avatar_2))
        list.add(CheckBoxItem("Brooklyn", imageDrawableRes = R.drawable.avatar_3))
        list.add(CheckBoxItem("Chelsea", imageDrawableRes = R.drawable.avatar_4))
        list.add(CheckBoxItem("Florence", imageDrawableRes = R.drawable.avatar_5))
        list.add(CheckBoxItem("Ireland", imageDrawableRes = R.drawable.avatar_6))
        return Observable.just(list)
    }
}