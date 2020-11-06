package com.decouikit.atom.components.cards.ecommerce_thumb.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_thumb.model.ThumbItem
import io.reactivex.Observable

object ThumbRepository {
    fun getData(context: Context): Observable<List<ThumbItem>> {
        val list = mutableListOf<ThumbItem>()

        list.add(
            ThumbItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ThumbItem(
                title = "Apple Mac Air (Early 2019, 64GB, Wi-Fi Only, SpaceG)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_4
            )
        )
        list.add(
            ThumbItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ThumbItem(
                title = "Apple Mac Air (Early 2019, 64GB, Wi-Fi Only, SpaceG)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_4
            )
        )
        list.add(
            ThumbItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_2
            )
        )
        list.add(
            ThumbItem(
                title = "Apple Mac Air (Early 2019, 64GB, Wi-Fi Only, SpaceG)",
                backgroundPhotoDrawableRes = R.drawable.card_shopping_bg_4
            )
        )
        return Observable.just(list)
    }
}