package com.decouikit.atom.components.navigation.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.model.NavProfileItem
import io.reactivex.Observable

object NavProfileRepository {

    fun getData(context: Context): Observable<List<NavProfileItem>> {
        val list = mutableListOf<NavProfileItem>()

        list.add(
            NavProfileItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "Atom Android UI Kit",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_1,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_1
            )
        )
        list.add(
            NavProfileItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "What’s new in Android?",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_2,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )

        list.add(
            NavProfileItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "Atom Android UI Kit",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_3,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_3
            )
        )
        list.add(
            NavProfileItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "What’s new in Android?",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_4,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_1
            )
        )
        list.add(
            NavProfileItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "Atom Android UI Kit",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_5,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )
        list.add(
            NavProfileItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "What’s new in Android?",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_2,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )
        return Observable.just(list)
    }
}