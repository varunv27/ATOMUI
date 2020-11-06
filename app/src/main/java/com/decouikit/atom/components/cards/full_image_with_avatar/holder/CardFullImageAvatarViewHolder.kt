package com.decouikit.atom.components.cards.full_image_with_avatar.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image_with_avatar.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.full_image_with_avatar.model.CardFullImageAvatarItem
import com.decouikit.atom.extensions.setImageBgFromDrawable
import kotlinx.android.synthetic.main.adapter_card_full_image_avatar.view.*

class CardFullImageAvatarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: CardFullImageAvatarItem? = null

    init {
        itemView.setOnClickListener(this)
        itemView.btnReadMore.setOnClickListener(this)
        itemView.ivLike.setOnClickListener(this)
    }

    fun bind(item: CardFullImageAvatarItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemView.tvItemTitle.text = item.title
        itemView.tvItemSubtitle.text = item.subtitle
        itemView.ivItemBg.setImageDrawable(item.backgroundPhotoDrawableRes?.let {
            ContextCompat.getDrawable(itemView.context,
                it
            )
        })
    }
    override fun onClick(v: View?) {
        when (v) {
            itemView -> {
                item?.let { listener?.onItemClick(it) }
            }
            itemView.btnReadMore -> {
                listener?.onButtonClick()
            }
            itemView.ivLike -> {
                if (item?.isLiked!!) {
                    item?.isLiked = false
                    itemView.ivLike.setImageBgFromDrawable(R.drawable.ic_heart)
                } else {
                    item?.isLiked = true
                    itemView.ivLike.setImageBgFromDrawable(R.drawable.ic_heart_selected)
                }
            }
        }
    }
}