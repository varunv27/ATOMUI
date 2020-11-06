package com.decouikit.atom.components.image_gallery.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.image_gallery.holder.ImageGalleryCategoryItemViewHolder
import com.decouikit.atom.components.image_gallery.interfaces.OnClickListener
import com.decouikit.atom.R
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import com.decouikit.atom.extensions.inflate

class ImageGalleryCategoryAdapter(private var list: List<ImageGalleryViewItem>) :
    RecyclerView.Adapter<ImageGalleryCategoryItemViewHolder>(), OnClickListener {

    var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGalleryCategoryItemViewHolder {
        return ImageGalleryCategoryItemViewHolder(parent.inflate(R.layout.image_gallery_category_adapter_item, false))
    }

    override fun onBindViewHolder(photoViewHolder: ImageGalleryCategoryItemViewHolder, position: Int) {
        photoViewHolder.bind(list[position], this)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onClickListener(item: ImageGalleryViewItem, position: Int) {
        onClickListener?.onClickListener(item, position)
    }
}