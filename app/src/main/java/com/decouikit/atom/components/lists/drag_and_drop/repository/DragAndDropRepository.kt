package com.decouikit.atom.components.lists.drag_and_drop.repository

import com.decouikit.atom.R
import com.decouikit.atom.components.lists.drag_and_drop.model.DragAndDropViewItem
import io.reactivex.Observable

object DragAndDropRepository {

    fun getData(): Observable<List<DragAndDropViewItem>> {
        val dragAndDropList = mutableListOf<DragAndDropViewItem>()
        dragAndDropList.add(
            DragAndDropViewItem(
                id = 1,
                title = "Lauren Simpson",
                avatarDrawableRes = R.drawable.avatar_1
            )
        )
        dragAndDropList.add(
            DragAndDropViewItem(
                id = 2,
                title = "Russell Gutierrez",
                avatarDrawableRes = R.drawable.avatar_2
            )
        )
        dragAndDropList.add(
            DragAndDropViewItem(
                id = 3,
                title = "Theresa Day",
                avatarDrawableRes = R.drawable.avatar_3
            )
        )
        dragAndDropList.add(
            DragAndDropViewItem(
                id = 4,
                title = "Vega Hayes",
                avatarDrawableRes = R.drawable.avatar_4
            )
        )
        dragAndDropList.add(
            DragAndDropViewItem(
                id = 5,
                title = "Kathleen Simmons",
                avatarDrawableRes = R.drawable.avatar_5
            )
        )
        dragAndDropList.add(
            DragAndDropViewItem(
                id = 6,
                title = "Alice Newman",
                avatarDrawableRes = R.drawable.avatar_6
            )
        )
        return Observable.just(dragAndDropList)

    }
}