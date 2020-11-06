package com.decouikit.atom.components.cards.full_image_with_avatar.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image_with_avatar.holder.CardFullImageAvatarViewHolder
import com.decouikit.atom.components.cards.full_image_with_avatar.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.full_image_with_avatar.model.CardFullImageAvatarItem
import com.decouikit.atom.extensions.inflate

class CardFullImageAvatarAdapter(private var items: ArrayList<CardFullImageAvatarItem>) :
    RecyclerView.Adapter<CardFullImageAvatarViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardFullImageAvatarViewHolder {
        return CardFullImageAvatarViewHolder(parent.inflate(R.layout.adapter_card_full_image_avatar, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CardFullImageAvatarViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}