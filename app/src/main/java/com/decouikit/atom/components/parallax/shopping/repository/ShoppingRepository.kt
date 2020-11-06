package com.decouikit.atom.components.parallax.shopping.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.shopping.model.ShoppingItem
import io.reactivex.Observable

object ShoppingRepository {
    fun getData(context: Context): Observable<List<ShoppingItem>> {
        val list = mutableListOf<ShoppingItem>()

        list.add(
            ShoppingItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ShoppingItem(
                title = "Apple Mac Air (Early 2019, 64GB, Wi-Fi Only, SpaceG)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_4
            )
        )
        list.add(
            ShoppingItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ShoppingItem(
                title = "Apple Mac Air (Early 2019, 64GB, Wi-Fi Only, SpaceG)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_4
            )
        )
        list.add(
            ShoppingItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ShoppingItem(
                title = "Apple Mac Air (Early 2019, 64GB, Wi-Fi Only, SpaceG)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_4
            )
        )
        return Observable.just(list)
    }
}