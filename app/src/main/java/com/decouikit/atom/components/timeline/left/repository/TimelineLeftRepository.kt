package com.decouikit.atom.components.timeline.left.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.left.model.TimelineLeftItem
import io.reactivex.Observable

object TimelineLeftRepository {

    fun getData(context: Context): Observable<List<TimelineLeftItem>> {
        val list = mutableListOf<TimelineLeftItem>()
        list.add(
            TimelineLeftItem(
                title = "Grant Marshall",
                subtitle = "@grant",
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Pena Valdez",
                subtitle = "@pena",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Jessica Miles",
                subtitle = "@jessica",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Kerri Barber",
                subtitle = "@kerri",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Natasha Gamble",
                subtitle = "@natasha",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineLeftItem(
                title = "White Castaneda",
                subtitle = "@white",
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Vanessa Ryan",
                subtitle = "@vanessa",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Meredith Hendricks",
                subtitle = "@meredith",
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Carol Kelly",
                subtitle = "@carol",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineLeftItem(
                title = "Barrera Ramsey",
                subtitle = "@barrera",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        return Observable.just(list)
    }
}