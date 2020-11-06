package com.decouikit.atom.components.timeline.right.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.right.model.TimelineRightItem
import io.reactivex.Observable

object TimelineRightRepository {

    fun getData(context: Context): Observable<List<TimelineRightItem>> {
        val list = mutableListOf<TimelineRightItem>()
        list.add(
            TimelineRightItem(
                title = "Grant Marshall",
                subtitle = "@grant",
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        list.add(
            TimelineRightItem(
                title = "Pena Valdez",
                subtitle = "@pena",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineRightItem(
                title = "Jessica Miles",
                subtitle = "@jessica",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineRightItem(
                title = "Kerri Barber",
                subtitle = "@kerri",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineRightItem(
                title = "Natasha Gamble",
                subtitle = "@natasha",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineRightItem(
                title = "White Castaneda",
                subtitle = "@white",
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        list.add(
            TimelineRightItem(
                title = "Vanessa Ryan",
                subtitle = "@vanessa",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineRightItem(
                title = "Meredith Hendricks",
                subtitle = "@meredith",
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        list.add(
            TimelineRightItem(
                title = "Carol Kelly",
                subtitle = "@carol",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineRightItem(
                title = "Barrera Ramsey",
                subtitle = "@barrera",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        return Observable.just(list)
    }
}