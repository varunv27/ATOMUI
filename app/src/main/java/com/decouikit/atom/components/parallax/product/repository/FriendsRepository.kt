package com.decouikit.atom.components.parallax.product.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.product.model.FriendListItem
import com.decouikit.atom.components.parallax.product.model.FriendsItem
import io.reactivex.Observable

object FriendsRepository {
    fun getData(context: Context): Observable<FriendsItem> {
        val list = mutableListOf<FriendListItem>()
        list.add(
            FriendListItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_1
            )
        )
        list.add(
            FriendListItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_2
            )
        )
        list.add(
            FriendListItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_3
            )
        )
        list.add(
            FriendListItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_4
            )
        )
        list.add(
            FriendListItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_1
            )
        )
        list.add(
            FriendListItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_2
            )
        )
        list.add(
            FriendListItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_3
            )
        )
        list.add(
            FriendListItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_4
            )
        )
        list.add(
            FriendListItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_1
            )
        )
        list.add(
            FriendListItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_2
            )
        )
        list.add(
            FriendListItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_3
            )
        )
        list.add(
            FriendListItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_4
            )
        )
        list.add(
            FriendListItem(
                title = "Plastic Glass",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_1
            )
        )
        list.add(
            FriendListItem(
                title = "Ice Cream",
                subtitle = "$3.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_2
            )
        )
        list.add(
            FriendListItem(
                title = "Fruits",
                subtitle = "$9.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_3
            )
        )
        list.add(
            FriendListItem(
                title = "Cosmetics",
                subtitle = "$5.95",
                backgroundPhotoDrawableRes = R.drawable.img_bg_4
            )
        )
        return Observable.just(
            FriendsItem(
                title = "Nikon Df DSLR Camera with 50mm f/1.8 Lens (Silver)",
                subtitle = "In Stock",
                tagName = "$1,195.00",
                description = "Whether raising your game to SLR level photography or having fun with a feature-rich, versatile SLR you can use pretty much anywhere, the EOS 80D camera is your.",
                buttonText = "Add to Cart",
                viewItems = list
            )
        )
    }
}