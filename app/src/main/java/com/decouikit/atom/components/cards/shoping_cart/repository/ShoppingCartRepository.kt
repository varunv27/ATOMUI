package com.decouikit.atom.components.cards.shoping_cart.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.shoping_cart.model.ShoppingCartItem
import io.reactivex.Observable

object ShoppingCartRepository {
    fun getData(): Observable<List<ShoppingCartItem>> {
        val list = mutableListOf<ShoppingCartItem>()

        list.add(
            ShoppingCartItem(
                title = "MacBook Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            ShoppingCartItem(
                title = "Pro Camera",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ShoppingCartItem(
                title = "Drone Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        list.add(
            ShoppingCartItem(
                title = "MacBook Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_1
            )
        )
        list.add(
            ShoppingCartItem(
                title = "Pro Camera",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ShoppingCartItem(
                title = "Drone Air",
                size = 2,
                subtitle = "x $995.95",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_3
            )
        )
        return Observable.just(list)
    }
}