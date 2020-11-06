package com.decouikit.atom.components.image_gallery.holder

import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.image_gallery.interfaces.OnClickListener
import com.decouikit.atom.components.image_gallery.model.ImageGalleryViewItem
import com.decouikit.atom.extensions.load
import kotlinx.android.synthetic.main.image_gallery_category_adapter_item.view.*
import kotlinx.android.synthetic.main.widget_expandable_item_indicator.view.*

class ImageGalleryCategoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var view: View = itemView
    private lateinit var item: ImageGalleryViewItem
    private var listener: OnClickListener? = null

    init {
        view.setOnClickListener(this)
    }

    fun bind(item: ImageGalleryViewItem, listener: OnClickListener?) {
        this.item = item
        this.listener = listener
        view.item.text = item.title
        view.textNumber.text = item.subtitle
        if (TextUtils.isEmpty(item.image)) {
            item.imageDrawableRes?.let {
                view.icon.load(item.imageDrawableRes)
            }
        } else {
            item.image?.let { view.image_view.load(it) }
        }
    }

    override fun onClick(view: View?) {
        listener?.onClickListener(item, adapterPosition)
    }
}