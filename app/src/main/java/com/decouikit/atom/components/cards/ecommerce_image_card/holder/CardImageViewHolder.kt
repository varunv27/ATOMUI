package com.decouikit.atom.components.cards.ecommerce_image_card.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.cards.ecommerce_image_card.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_image_card.model.CardImageItem
import kotlinx.android.synthetic.main.adapter_card_image.view.*

class CardImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: CardImageItem? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: CardImageItem, listener: OnItemClickListener) {
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
        }
    }
}