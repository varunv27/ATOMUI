package com.decouikit.atom.components.wizard.e_commerce.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.e_commerce.model.WizardECommerceItem
import io.reactivex.Observable

object WizardECommerceRepository {

    fun getData(context: Context): Observable<WizardECommerceItem> {

        val pageOne = WizardECommerceItem(
            title = "Nikon DF Retro",
            subtitle = "$ 1,299.99",
            backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_1
        )
        val pageTwo = WizardECommerceItem(
            title = "Macbook Air",
            subtitle = "$ 959.99",
            backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_2
        )


        val pageThree = WizardECommerceItem(
            title = "Nikon DF Retro",
            subtitle = "$ 1,299.99",
            backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_1
        )


        val pageFour = WizardECommerceItem(
            title = "Macbook Air",
            subtitle = "$ 959.99",
            backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_2
        )


        val pageFive = WizardECommerceItem(
            title = "Nikon DF Retro",
            subtitle = "$ 1,299.99",
            backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_1
        )

        val pageSix = WizardECommerceItem(
            title = "Macbook Air",
            subtitle = "$ 959.99",
            backgroundPhotoDrawableRes = R.drawable.card_full_image_avatar_2
        )

        return Observable.just(pageOne, pageTwo, pageThree, pageFour, pageFive, pageSix)
    }
}