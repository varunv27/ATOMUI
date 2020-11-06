package com.decouikit.atom.components.cards.shoping_cart.holder

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.shoping_cart.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.shoping_cart.model.ShoppingCartItem
import kotlinx.android.synthetic.main.adapter_card_shopping_cart.view.*

class ShoppingCartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener {


    private var listener: OnItemClickListener? = null
    private var item: ShoppingCartItem? = null

    init {
        itemView.setOnClickListener(this)
        itemView.ivAdd.setOnClickListener(this)
        itemView.ivRemove.setOnClickListener(this)
    }

    fun bind(item: ShoppingCartItem, listener: OnItemClickListener) {
        this.item = item
        this.listener = listener
        itemView.textName.text = item.title
        itemView.textPrice.text =
            itemView.context.getString(R.string.shopping_cart_value, item.size, item.subtitle)
        itemView.imageAvatar.setImageDrawable(item.backgroundPhotoDrawableRes?.let {
            ContextCompat.getDrawable(
                itemView.context,
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