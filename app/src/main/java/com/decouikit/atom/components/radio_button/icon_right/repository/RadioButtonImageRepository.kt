package com.decouikit.atom.components.radio_button.icon_right.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.icon_right.model.RadioButtonItem
import io.reactivex.Observable

object RadioButtonImageRepository {
    fun getData(context: Context) : Observable<List<RadioButtonItem>> {
        val list = mutableListOf<RadioButtonItem>()
        list.add(RadioButtonItem("Paris", imageDrawableRes = R.drawable.ic_icon_1))
        list.add(RadioButtonItem("Alabama", imageDrawableRes = R.drawable.ic_icon_2))
        list.add(RadioButtonItem("Brooklyn", imageDrawableRes = R.drawable.ic_icon_3))
        list.add(RadioButtonItem("Chelsea", imageDrawableRes = R.drawable.ic_icon_4))
        list.add(RadioButtonItem("Florence", imageDrawableRes = R.drawable.ic_icon_1))
        list.add(RadioButtonItem("Ireland", imageDrawableRes = R.drawable.ic_icon_2))
        return Observable.just(list)
    }
}
