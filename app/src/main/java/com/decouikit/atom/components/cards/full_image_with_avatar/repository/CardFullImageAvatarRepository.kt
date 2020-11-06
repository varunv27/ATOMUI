package com.decouikit.atom.components.cards.full_image_with_avatar.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image_with_avatar.model.CardFullImageAvatarItem
import io.reactivex.Observable

object CardFullImageAvatarRepository {

    fun getData(context: Context): Observable<List<CardFullImageAvatarItem>> {
        val list = mutableListOf<CardFullImageAvatarItem>()

        list.add(
            CardFullImageAvatarItem(
                title = "Nikon DF Retro",
                subtitle = "$ 1,299.99",
                backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_1
            )
        )
        list.add(
            CardFullImageAvatarItem(
                title = "Macbook Air",
                subtitle = "$ 959.99",
                backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_2
            )
        )
        list.add(
            CardFullImageAvatarItem(
                title = "Nikon DF Retro",
                subtitle = "$ 1,299.99",
                backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_1
            )
        )
        list.add(
            CardFullImageAvatarItem(
                title = "Macbook Air",
                subtitle = "$ 959.99",
                backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_2
            )
        )
        list.add(
            CardFullImageAvatarItem(
                title = "Nikon DF Retro",
                subtitle = "$ 1,299.99",
                backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_1
            )
        )
        list.add(
            CardFullImageAvatarItem(
                title = "Macbook Air",
                subtitle = "$ 959.99",
                backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_2
            )
        )

        return Observable.just(list)
    }
}