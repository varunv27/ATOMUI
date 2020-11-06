package com.decouikit.atom.components.wizard.social.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.social.model.WizardSocialItem
import io.reactivex.Observable

object WizardSocialRepository {

    fun getData(context: Context): Observable<WizardSocialItem> {

        val pageOne = WizardSocialItem(
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
            subtitle = "Atom Android UI Kit",
            name = "Grace Palmer",
            articles = "29 Articles",
            avatarDrawableRes = R.drawable.avatar_1,
            backgroundPhotoDrawableRes = R.drawable.skate_3
        )

        val pageTwo = WizardSocialItem(
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
            subtitle = "What’s new in Android?",
            name = "Grace Palmer",
            articles = "29 Articles",
            avatarDrawableRes = R.drawable.avatar_2,
            backgroundPhotoDrawableRes = R.drawable.skate_8
        )


        val pageThree = WizardSocialItem(
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
            subtitle = "Atom Android UI Kit",
            name = "Grace Palmer",
            articles = "29 Articles",
            avatarDrawableRes = R.drawable.avatar_3,
            backgroundPhotoDrawableRes = R.drawable.skate_3
        )


        val pageFour = WizardSocialItem(
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
            subtitle = "What’s new in Android?",
            name = "Grace Palmer",
            articles = "29 Articles",
            avatarDrawableRes = R.drawable.avatar_4,
            backgroundPhotoDrawableRes = R.drawable.skate_8
        )


        val pageFive = WizardSocialItem(
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
            subtitle = "Atom Android UI Kit",
            name = "Grace Palmer",
            articles = "29 Articles",
            avatarDrawableRes = R.drawable.avatar_5,
            backgroundPhotoDrawableRes = R.drawable.skate_3
        )

        val pageSix = WizardSocialItem(
            title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at est purus.",
            subtitle = "What’s new in Android?",
            name = "Grace Palmer",
            articles = "29 Articles",
            avatarDrawableRes = R.drawable.avatar_2,
            backgroundPhotoDrawableRes = R.drawable.skate_8
        )

        return Observable.just(pageOne, pageTwo, pageThree, pageFour, pageFive, pageSix)
    }
}