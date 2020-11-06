package com.decouikit.atom.components.wizard.profile.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.profile.model.WizardProfileItem
import io.reactivex.Observable

object WizardProfileRepository {

    fun getData(context: Context): Observable<WizardProfileItem> {

        val pageOne = WizardProfileItem(
            title = "Tiffany Pearson",
            subtitle = "Product Designer",
            avatarDrawableRes = R.drawable.avatar_1
        )

        val pageTwo = WizardProfileItem(
            title = "Tiffany Pearson",
            subtitle = "Product Designer",
            avatarDrawableRes = R.drawable.avatar_2
        )


        val pageThree = WizardProfileItem(
            title = "Tiffany Pearson",
            subtitle = "Product Designer",
            avatarDrawableRes = R.drawable.avatar_3
        )


        val pageFour = WizardProfileItem(
            title = "Tiffany Pearson",
            subtitle = "Product Designer",
            avatarDrawableRes = R.drawable.avatar_4
        )


        val pageFive = WizardProfileItem(
            title = "Tiffany Pearson",
            subtitle = "Product Designer",
            avatarDrawableRes = R.drawable.avatar_5
        )

        val pageSix = WizardProfileItem(
            title = "Tiffany Pearson",
            subtitle = "Product Designer",
            avatarDrawableRes = R.drawable.avatar_2
        )

        return Observable.just(pageOne, pageTwo, pageThree, pageFour, pageFive, pageSix)
    }
}