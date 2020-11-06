package com.decouikit.atom.components.parallax.profile.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.profile.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.profile.model.ProfileListItem
import com.decouikit.atom.extensions.setImageBgFromDrawable
import kotlinx.android.synthetic.main.adapter_card_styled.view.*

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var listener: OnItemClickListener? = null
    private var item: ProfileListItem? = null

    init {
        itemView.setOnClickListener(this)
        itemView.tvItemComments.setOnClickListener(this)
        itemView.ivLike.setOnClickListener(this)
        itemView.tvItemLikes.setOnClickListener(this)
    }

    fun bind(item: ProfileListItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener

        itemView.tvItemTitle.text = item.title
        itemView.tvItemSubtitle.text = item.subtitle
        itemView.tvItemComments.text = item.comments.toString()
        itemView.tvItemLikes.text = item.likes.toString()
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
            itemView.tvItemComments -> {
                listener?.onCommentsClick()
            }
            itemView.tvItemLikes,
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