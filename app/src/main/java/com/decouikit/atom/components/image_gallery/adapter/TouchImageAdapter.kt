package com.decouikit.atom.components.image_gallery.adapter

import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import com.decouikit.atom.components.image_gallery.util.TouchImageView
import com.decouikit.atom.extensions.load

class TouchImageAdapter(val items: ArrayList<ImageGalleryViewItem>) : PagerAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image = TouchImageView(container.context)
        if (!TextUtils.isEmpty(items[position].image)) {
            items[position].image?.let {
                image.load(it)
            }
        } else {
            items[position].imageDrawableRes?.let {
                image.load(it)
            }
        }
        container.addView(image, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        return image
    }

    override fun isViewFromObject(view: View, itemObject: Any): Boolean {
        return view == itemObject
    }

    override fun destroyItem(container: ViewGroup, position: Int, itemObject: Any) {
        container.removeView(itemObject as View)
    }
}
