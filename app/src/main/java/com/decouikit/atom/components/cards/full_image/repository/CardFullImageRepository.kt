package com.decouikit.atom.components.cards.full_image.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image.model.CardFullImageItem
import io.reactivex.Observable

object CardFullImageRepository {

    fun getData(context: Context): Observable<List<CardFullImageItem>> {
        val list = mutableListOf<CardFullImageItem>()

        list.add(
            CardFullImageItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_full_image_1
            )
        )
        list.add(
            CardFullImageItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_full_image_2
            )
        )
        list.add(
            CardFullImageItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_full_image_1
            )
        )
        list.add(
            CardFullImageItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_full_image_2
            )
        )
        list.add(
            CardFullImageItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_full_image_1
            )
        )
        list.add(
            CardFullImageItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_full_image_2
            )
        )
        return Observable.just(list)
    }
}