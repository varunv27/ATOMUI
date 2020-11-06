package com.decouikit.atom.components.navigation.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.model.NavProductItem
import io.reactivex.Observable

object NavProductRepository {
    fun getData(context: Context): Observable<List<NavProductItem>> {
        val list = mutableListOf<NavProductItem>()
        
        list.add(
            NavProductItem(
                title = "MacBook Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            NavProductItem(
                title = "Pro Camera",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            NavProductItem(
                title = "Drone Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        list.add(
            NavProductItem(
                title = "MacBook Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            NavProductItem(
                title = "Pro Camera",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            NavProductItem(
                title = "Drone Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        return Observable.just(list)
    }
}