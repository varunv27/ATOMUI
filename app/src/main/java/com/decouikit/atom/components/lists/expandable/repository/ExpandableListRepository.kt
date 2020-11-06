package com.decouikit.atom.components.lists.expandable.repository

import com.decouikit.atom.R
import com.decouikit.atom.components.lists.expandable.model.ExpandableSubItemView
import com.decouikit.atom.components.lists.expandable.model.ExpandableViewItem
import io.reactivex.Observable

object ExpandableListRepository {

    fun getData(): Observable<List<ExpandableViewItem>> {
        val expandableList = mutableListOf<ExpandableViewItem>()

        val expandableViewSubItems1 = mutableListOf<ExpandableSubItemView>()
        expandableViewSubItems1.add(ExpandableSubItemView(
            1,
            "Paris",
            "Tertiary",
            tagBgRes = R.drawable.rounded_tag_bg_1,
            tagTextColor = R.color.colorTagText1,
            avatarDrawableRes = R.drawable.avatar_1))
        expandableViewSubItems1.add(ExpandableSubItemView(
            2,
            "Alabama",
            "Secondary",
            tagBgRes = R.drawable.rounded_tag_bg_2,
            tagTextColor = R.color.colorTagText2,
            avatarDrawableRes = R.drawable.avatar_2))
        expandableViewSubItems1.add(ExpandableSubItemView(
            3,
            "Brooklyn",
            "Primary",
            tagBgRes = R.drawable.rounded_tag_bg_3,
            tagTextColor = R.color.colorTagText3,
            avatarDrawableRes = R.drawable.avatar_3))
        expandableViewSubItems1.add(ExpandableSubItemView(
            4,
            "Chelsea",
            "Primary",
            tagBgRes = R.drawable.rounded_tag_bg_3,
            tagTextColor = R.color.colorTagText3,
            avatarDrawableRes = R.drawable.avatar_4))
        expandableViewSubItems1.add(ExpandableSubItemView(
            5,
            "Florence",
            "Secondary",
            tagBgRes = R.drawable.rounded_tag_bg_2,
            tagTextColor = R.color.colorTagText2,
            avatarDrawableRes = R.drawable.avatar_5))
        expandableViewSubItems1.add(ExpandableSubItemView(
            6,
            "Ireland",
            "Tertiary",
            tagBgRes = R.drawable.rounded_tag_bg_1,
            tagTextColor = R.color.colorTagText1,
            avatarDrawableRes = R.drawable.avatar_6))

        val expandableViewItem1 = ExpandableViewItem(
            1,
            title = "Followers",
            subItems = expandableViewSubItems1
        )

        val expandableViewItem2 = ExpandableViewItem(
            2,
            title = "Following",
            subItems = expandableViewSubItems1
        )

        val expandableViewItem3 = ExpandableViewItem(
            3,
            title = "Discover users",
            subItems = expandableViewSubItems1
        )

        expandableList.add(expandableViewItem1)
        expandableList.add(expandableViewItem2)
        expandableList.add(expandableViewItem3)

        return Observable.just(expandableList)
    }
}