package com.decouikit.atom.components.image_gallery.repository

import android.content.Context
import com.decouikit.atom.R
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import io.reactivex.Observable

object ImageGalleryRepository {

    fun getData(context: Context): Observable<List<ImageGalleryViewItem>> {
        val gallery = mutableListOf<ImageGalleryViewItem>()
        val subTitleTemplateString = context.getString(R.string.image_gallery_subtitle_template)

        gallery.add(
            ImageGalleryViewItem(
                title = "Plastic Glass",
                subtitle = String.format(subTitleTemplateString, getGlasses().size),
                imageDrawableRes = R.drawable.img_bg_1,
                imageViews = getGlasses()
            )
        )
        gallery.add(
            ImageGalleryViewItem(
                title = "Ice Cream",
                subtitle = String.format(subTitleTemplateString, getIceCream().size),
                imageDrawableRes = R.drawable.img_bg_2,
                imageViews = getIceCream()
            )
        )
        gallery.add(
            ImageGalleryViewItem(
                title = "Fruits",
                subtitle = String.format(subTitleTemplateString, getFruits().size),
                imageDrawableRes = R.drawable.img_bg_3,
                imageViews = getFruits()
            )
        )
        gallery.add(
            ImageGalleryViewItem(
                title = "Cosmetics",
                subtitle = String.format(subTitleTemplateString, getCosmetics().size),
                imageDrawableRes = R.drawable.img_bg_4,
                imageViews = getCosmetics()
            )
        )
        gallery.add(
            ImageGalleryViewItem(
                title = "Skateboard",
                subtitle = String.format(subTitleTemplateString, getSkateBoards().size),
                imageDrawableRes = R.drawable.skate_0,
                imageViews = getSkateBoards()
            )
        )
        gallery.add(
            ImageGalleryViewItem(
                title = "Donuts",
                subtitle = String.format(subTitleTemplateString, getDonuts().size),
                imageDrawableRes = R.drawable.donnuts_0,
                imageViews = getDonuts()
            )
        )
        return Observable.just(gallery)
    }

    private fun getGlasses(): List<ImageGalleryViewItem> {
        val subImageGallery = mutableListOf<ImageGalleryViewItem>()
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.glass_1
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.glass_2
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.glass_3
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.glass_4
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.glass_5
            )
        )
        return subImageGallery
    }

    private fun getIceCream(): List<ImageGalleryViewItem> {
        val subImageGallery = mutableListOf<ImageGalleryViewItem>()
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_1
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_2
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_3
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_4
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_5
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_6
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.ice_cream_7
            )
        )
        return subImageGallery
    }

    private fun getFruits(): List<ImageGalleryViewItem> {
        val subImageGallery = mutableListOf<ImageGalleryViewItem>()
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_1
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_2
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_3
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_4
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_5
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_6
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.fruit_7
            )
        )
        return subImageGallery
    }

    private fun getCosmetics(): List<ImageGalleryViewItem> {
        val subImageGallery = mutableListOf<ImageGalleryViewItem>()
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_1
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_2
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_3
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_4
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_5
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_6
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.comsetics_7
            )
        )
        return subImageGallery
    }

    private fun getSkateBoards(): List<ImageGalleryViewItem> {
        val subImageGallery = mutableListOf<ImageGalleryViewItem>()
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_1
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_2
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_3
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_4
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_5
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_6
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_7
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.skate_8
            )
        )
        return subImageGallery
    }

    private fun getDonuts(): List<ImageGalleryViewItem> {
        val subImageGallery = mutableListOf<ImageGalleryViewItem>()
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.donnuts_1
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.donnuts_2
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.donnuts_3
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.donnuts_4
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.donnuts_5
            )
        )
        subImageGallery.add(
            ImageGalleryViewItem(
                imageDrawableRes = R.drawable.donnuts_6
            )
        )
        return subImageGallery
    }
}