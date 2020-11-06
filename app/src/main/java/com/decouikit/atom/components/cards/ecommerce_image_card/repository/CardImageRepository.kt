package com.decouikit.atom.components.cards.ecommerce_image_card.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_image_card.model.CardImageItem
import io.reactivex.Observable

object CardImageRepository {
    fun getData(context: Context): Observable<List<CardImageItem>> {
        val list = mutableListOf<CardImageItem>()
        list.add(
            CardImageItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.glass_1
            )
        )
        list.add(
            CardImageItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.ice_cream_2
            )
        )
        list.add(
            CardImageItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.fruit_2
            )
        )
        list.add(
            CardImageItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.comsetics_1
            )
        )
        list.add(
            CardImageItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.glass_2
            )
        )
        list.add(
            CardImageItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.ice_cream_2
            )
        )
        list.add(
            CardImageItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.fruit_2
            )
        )
        list.add(
            CardImageItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.comsetics_1
            )
        )
        list.add(
            CardImageItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.glass_3
            )
        )
        list.add(
            CardImageItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.ice_cream_3
            )
        )
        list.add(
            CardImageItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.fruit_2
            )
        )
        list.add(
            CardImageItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.comsetics_1
            )
        )
        list.add(
            CardImageItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.glass_1
            )
        )
        list.add(
            CardImageItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.ice_cream_2
            )
        )
        list.add(
            CardImageItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.fruit_4
            )
        )
        list.add(
            CardImageItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.comsetics_1
            )
        )
        return Observable.just(list)
    }
}