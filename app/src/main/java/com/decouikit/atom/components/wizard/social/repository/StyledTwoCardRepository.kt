package com.decouikit.atom.components.wizard.social.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.social.model.StyledTwoCardItem
import io.reactivex.Observable

object StyledTwoCardRepository {

    fun getData(context: Context): Observable<List<StyledTwoCardItem>> {
        val list = mutableListOf<StyledTwoCardItem>()

        list.add(
            StyledTwoCardItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "Atom Android UI Kit",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_1,
                backgroundPhotoDrawableRes = R.drawable.skate_3
            )
        )
        list.add(
            StyledTwoCardItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "What’s new in Android?",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_2,
                backgroundPhotoDrawableRes = R.drawable.skate_8
            )
        )

        list.add(
            StyledTwoCardItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "Atom Android UI Kit",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_3,
                backgroundPhotoDrawableRes = R.drawable.skate_4
            )
        )
        list.add(
            StyledTwoCardItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "What’s new in Android?",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_4,
                backgroundPhotoDrawableRes = R.drawable.skate_8
            )
        )
        list.add(
            StyledTwoCardItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "Atom Android UI Kit",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_5,
                backgroundPhotoDrawableRes = R.drawable.skate_3
            )
        )
        list.add(
            StyledTwoCardItem(
                title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
                subtitle = "What’s new in Android?",
                name = "Grace Palmer",
                articles = "29 Articles",
                avatarDrawableRes = R.drawable.avatar_2,
                backgroundPhotoDrawableRes = R.drawable.skate_8
            )
        )
        return Observable.just(list)
    }
}