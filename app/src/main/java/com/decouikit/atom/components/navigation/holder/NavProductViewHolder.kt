package com.decouikit.atom.components.navigation.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.interfaces.OnProductItemClickListener
import com.decouikit.atom.components.navigation.model.NavProductItem
import kotlinx.android.synthetic.main.adapter_card_shopping_cart.view.*

class NavProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {


    private var listener: OnProductItemClickListener? = null
    private var item: NavProductItem? = null

    init {
        itemView.setOnClickListener(this)
        itemView.ivAdd.setOnClickListener(this)
        itemView.ivRemove.setOnClickListener(this)
    }

    fun bind(item: NavProductItem, listener: OnProductItemClickListener) {
        this.item = item
        this.listener = listener
        itemView.textName.text = item.title
        itemView.textPrice.text =
            itemView.context.getString(R.string.shopping_cart_value, item.size, item.subtitle)
        itemView.imageAvatar.setImageDrawable(item.backgroundPhotoDrawableRes?.let {
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
            itemView.ivAdd -> {
                item?.let { listener?.onAddClick(it) }
            }
            itemView.ivRemove -> {
                item?.let { listener?.onRemoveClick(it) }
            }
        }
    }
}