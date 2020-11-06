package com.decouikit.atom.components.cards.full_image.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image.holder.CardFullImageViewHolder
import com.decouikit.atom.components.cards.full_image.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.full_image.model.CardFullImageItem
import com.decouikit.atom.extensions.inflate

class CardFullImageAdapter(private var items: ArrayList<CardFullImageItem>) :
    RecyclerView.Adapter<CardFullImageViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardFullImageViewHolder {
        return CardFullImageViewHolder(parent.inflate(R.layout.adapter_card_full_image, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CardFullImageViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}