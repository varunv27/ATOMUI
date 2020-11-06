package com.decouikit.atom.components.parallax.profile.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.profile.model.ProfileBaseItem
import com.decouikit.atom.components.parallax.profile.model.ProfileListItem
import io.reactivex.Observable

object ProfileRepository {

    fun getData(context: Context): Observable<ProfileBaseItem> {
        val list = mutableListOf<ProfileListItem>()
        list.add(
            ProfileListItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_1
            )
        )
        list.add(
            ProfileListItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )
        list.add(
            ProfileListItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_3
            )
        )
        list.add(
            ProfileListItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_2
            )
        )
        list.add(
            ProfileListItem(
                title = "A New Design Model That Helps People Change Their Lives",
                subtitle = "ART & DESIGN",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_1
            )
        )
        list.add(
            ProfileListItem(
                title = "How might we help people become better-informed citizens?",
                subtitle = "TECHNOLOGY",
                comments = 67,
                likes = 782,
                backgroundPhotoDrawableRes = R.drawable.card_styled_bg_3
            )
        )
        return Observable.just(
            ProfileBaseItem(
                title = "Tiffany Pearson",
                subtitle = "Product Designer",
                avatarDrawableRes = R.drawable.avatar_1,
                button1Text = "Follow",
                button2Text = "Message",
                viewItems = list
            )
        )
    }
}