package com.decouikit.atom.components.image_gallery.activity

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.image_gallery.fragment.ImageGalleryFullImageFragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import kotlinx.android.synthetic.main.activity_generic.*

class FullImageActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        val galleryList = intent.getParcelableArrayListExtra<ImageGalleryViewItem>("item")
        val position = intent.getIntExtra("position", 0)
        callback.invoke(ImageGalleryFullImageFragment.newInstance(galleryList as ArrayList<ImageGalleryViewItem>, position))
    }

    override fun loadTag(): String {
        return "FullImageTag"
    }
}
