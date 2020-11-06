package com.decouikit.atom.components.image_gallery.interfaces

import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem

interface OnClickListener {
    fun onClickListener(item: ImageGalleryViewItem, position: Int)
}
