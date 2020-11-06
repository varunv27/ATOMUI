package com.decouikit.atom.components.lists.swipe.button.repository

import com.decouikit.atom.R
import com.decouikit.atom.components.lists.swipe.button.model.SwipeViewItem
import io.reactivex.Observable

object SwipeRepository {
    fun getData(): Observable<List<SwipeViewItem>> {
        val swipeList = mutableListOf<SwipeViewItem>()
        swipeList.add(
            SwipeViewItem(
                id = 1,
                title = "Lauren Simpson",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        swipeList.add(
            SwipeViewItem(
                id = 2,
                title = "Russell Gutierrez",
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        swipeList.add(
            SwipeViewItem(
                id = 3,
                title = "Theresa Day",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        swipeList.add(
            SwipeViewItem(
                id = 4,
                title = "Vega Hayes",
                avatarDrawableRes = R.drawable.avatar_4
            )
        )
        swipeList.add(
            SwipeViewItem(
                id = 5,
                title = "Kathleen Simmons",
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        swipeList.add(
            SwipeViewItem(
                id = 6,
                title = "Alice Newman",
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        return Observable.just(swipeList)
    }
}