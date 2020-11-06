package com.decouikit.atom.components.image_gallery.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.image_gallery.fragment.ImageGalleryCategoryFragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import com.decouikit.atom.components.image_gallery.repository.ImageGalleryRepository

class ImageGalleryCategoryActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.image_gallery_categories))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ImageGalleryRepository.getData(this).subscribe {
            callback.invoke(ImageGalleryCategoryFragment.newInstance(it as ArrayList<ImageGalleryViewItem>))
        }
    }

    override fun loadTag(): String {
        return "ImageGalleryCategoryTag"
    }
}
