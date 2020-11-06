package com.decouikit.atom.components.navigation.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.components.navigation.interfaces.OnProfileItemClickListener
import com.decouikit.atom.components.navigation.model.NavProfileItem
import com.decouikit.atom.extensions.setButtonText
import kotlinx.android.synthetic.main.adapter_card_styled_two.view.*

class NavProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {

    private var listener: OnProfileItemClickListener? = null
    private var item: NavProfileItem? = null

    init {
        itemView.setOnClickListener(this)
        itemView.btnFollowing.setOnClickListener(this)
    }

    fun bind(item: NavProfileItem, listener: OnProfileItemClickListener) {
        this.item = item
        this.listener = listener

        itemView.tvItemTitle.text = item.title
        itemView.tvItemSubtitle.text = item.subtitle
        itemView.textName.text = item.name
        itemView.textArticles.text = item.articles
        itemView.ivItemBg.setImageDrawable(item.backgroundPhotoDrawableRes?.let {
            ContextCompat.getDrawable(itemView.context,
                it
            )
        })
        itemView.imageAvatar.setImageDrawable(item.avatarDrawableRes?.let {
            ContextCompat.getDrawable(itemView.context,
                it
            )
        })
    }

    override fun onClick(v: View?) {
        when(v) {
            itemView -> {
                item?.let { listener?.onItemClick(it) }
            }
            itemView.btnFollowing -> {
                item?.isFollowing = !item?.isFollowing!!
                itemView.btnFollowing.setButtonText(item?.isFollowing!!)
            }
        }
    }
}