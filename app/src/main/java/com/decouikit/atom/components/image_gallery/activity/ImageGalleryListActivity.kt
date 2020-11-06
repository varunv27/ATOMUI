package com.decouikit.atom.components.image_gallery.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.image_gallery.fragment.ImageGalleryListFragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem

class ImageGalleryListActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.image_gallery_category_title))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        val gallery = intent.getParcelableExtra<ImageGalleryViewItem>("item")
        callback.invoke(ImageGalleryListFragment.newInstance(gallery?.imageViews as ArrayList<ImageGalleryViewItem>))
    }

    override fun loadTag(): String {
        return "ImageGalleryListTag"
    }
}
