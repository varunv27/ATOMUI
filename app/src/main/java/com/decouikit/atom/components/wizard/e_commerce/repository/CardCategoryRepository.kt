package com.decouikit.atom.components.wizard.e_commerce.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.e_commerce.model.CardCategoryItem
import io.reactivex.Observable

object CardCategoryRepository {
    fun getData(context: Context): Observable<List<CardCategoryItem>> {
        val list = mutableListOf<CardCategoryItem>()
        list.add(
            CardCategoryItem(
                title = "56 Products",
                subtitle = "MacBook Air",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            CardCategoryItem(
                title = "7 Products",
                subtitle = "Drones",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        list.add(
            CardCategoryItem(
                title = "55 Products",
                subtitle = "Pro Cameras",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            CardCategoryItem(
                title = "19 Products",
                subtitle = "Television",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_5
            )
        )
        list.add(
            CardCategoryItem(
                title = "56 Products",
                subtitle = "MacBook Air",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            CardCategoryItem(
                title = "7 Products",
                subtitle = "Drones",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        list.add(
            CardCategoryItem(
                title = "55 Products",
                subtitle = "Pro Cameras",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            CardCategoryItem(
                title = "19 Products",
                subtitle = "Television",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_5
            )
        )
        list.add(
            CardCategoryItem(
                title = "56 Products",
                subtitle = "MacBook Air",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            CardCategoryItem(
                title = "7 Products",
                subtitle = "Drones",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        list.add(
            CardCategoryItem(
                title = "55 Products",
                subtitle = "Pro Cameras",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            CardCategoryItem(
                title = "19 Products",
                subtitle = "Television",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_5
            )
        )
        list.add(
            CardCategoryItem(
                title = "56 Products",
                subtitle = "MacBook Air",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            CardCategoryItem(
                title = "7 Products",
                subtitle = "Drones",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        list.add(
            CardCategoryItem(
                title = "55 Products",
                subtitle = "Pro Cameras",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            CardCategoryItem(
                title = "19 Products",
                subtitle = "Television",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_5
            )
        )

        return Observable.just(list)
    }
}