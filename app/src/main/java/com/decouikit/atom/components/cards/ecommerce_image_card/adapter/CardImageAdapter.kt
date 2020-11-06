package com.decouikit.atom.components.cards.ecommerce_image_card.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_image_card.holder.CardImageViewHolder
import com.decouikit.atom.components.cards.ecommerce_image_card.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_image_card.model.CardImageItem
import com.decouikit.atom.extensions.inflate

class CardImageAdapter(private var items: ArrayList<CardImageItem>) :
    RecyclerView.Adapter<CardImageViewHolder>() {

    private var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardImageViewHolder {
        return CardImageViewHolder(parent.inflate(R.layout.adapter_card_image, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CardImageViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}