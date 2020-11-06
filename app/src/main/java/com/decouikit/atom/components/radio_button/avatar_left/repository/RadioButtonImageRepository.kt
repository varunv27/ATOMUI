package com.decouikit.atom.components.radio_button.avatar_left.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.avatar_left.model.RadioButtonItem
import io.reactivex.Observable

object RadioButtonImageRepository {
    fun getData(context: Context) : Observable<List<RadioButtonItem>> {
        val list = mutableListOf<RadioButtonItem>()
        list.add(RadioButtonItem("Paris", imageDrawableRes = R.drawable.avatar_1))
        list.add(RadioButtonItem("Alabama", imageDrawableRes = R.drawable.avatar_2))
        list.add(RadioButtonItem("Brooklyn", imageDrawableRes = R.drawable.avatar_3))
        list.add(RadioButtonItem("Chelsea", imageDrawableRes = R.drawable.avatar_4))
        list.add(RadioButtonItem("Florence", imageDrawableRes = R.drawable.avatar_5))
        list.add(RadioButtonItem("Ireland", imageDrawableRes = R.drawable.avatar_6))
        return Observable.just(list)
    }
}