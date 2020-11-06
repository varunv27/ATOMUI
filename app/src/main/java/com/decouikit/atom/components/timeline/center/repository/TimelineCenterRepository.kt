package com.decouikit.atom.components.timeline.center.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.center.model.TimelineCenterItem
import com.decouikit.atom.components.timeline.center.model.TimelineType
import io.reactivex.Observable

object TimelineCenterRepository {

    fun getData(context: Context): Observable<List<TimelineCenterItem>> {
        val list = mutableListOf<TimelineCenterItem>()
        list.add(
            TimelineCenterItem(
                title = "Grant",
                subtitle = "@grant",
                position = TimelineType.LEFT,
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Pena",
                subtitle = "@pena",
                position = TimelineType.RIGHT,
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Carol",
                subtitle = "@carol",
                position = TimelineType.LEFT,
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Kerri",
                subtitle = "@kerri",
                position = TimelineType.RIGHT,
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Pena",
                subtitle = "@pena",
                position = TimelineType.LEFT,
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineCenterItem(
                title = "White",
                subtitle = "@white",
                position = TimelineType.RIGHT,
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Grant",
                subtitle = "@grant",
                position = TimelineType.LEFT,
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Pena",
                subtitle = "@pena",
                position = TimelineType.RIGHT,
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Carol",
                subtitle = "@carol",
                position = TimelineType.LEFT,
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        list.add(
            TimelineCenterItem(
                title = "Pena",
                subtitle = "@pena",
                position = TimelineType.RIGHT,
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        return Observable.just(list)
    }
}