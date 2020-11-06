package com.decouikit.atom.components.cards.social_thumb.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.social_thumb.model.SocialThumbItem
import io.reactivex.Observable

object SocialThumbRepository {
    fun getData(context: Context): Observable<List<SocialThumbItem>> {
        val list = mutableListOf<SocialThumbItem>()
        list.add(
            SocialThumbItem(
                title = "Atom UI Kit",
                subtitle = "Lorem ipsum dolor sit…",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.img_bg_1
            )
        )
        list.add(
            SocialThumbItem(
                title = "Android Platform",
                subtitle = "Consectetur adipiscing…",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.img_bg_2
            )
        )
        list.add(
            SocialThumbItem(
                title = "Sketch Files",
                subtitle = "Consectetur adipiscing…",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.img_bg_3
            )
        )
        list.add(
            SocialThumbItem(
                title = "Atom UI Kit",
                subtitle = "Lorem ipsum dolor sit…",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.img_bg_1
            )
        )
        list.add(
            SocialThumbItem(
                title = "Android Platform",
                subtitle = "Consectetur adipiscing…",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.img_bg_2
            )
        )
        list.add(
            SocialThumbItem(
                title = "Sketch Files",
                subtitle = "Consectetur adipiscing…",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.img_bg_3
            )
        )
        return Observable.just(list)
    }
}