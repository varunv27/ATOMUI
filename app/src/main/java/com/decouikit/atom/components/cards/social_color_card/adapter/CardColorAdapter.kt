package com.decouikit.atom.components.cards.social_color_card.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.social_color_card.holder.CardColorViewHolder
import com.decouikit.atom.components.cards.social_color_card.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.social_color_card.model.CardColorItem
import com.decouikit.atom.extensions.inflate

class CardColorAdapter(private var items: ArrayList<CardColorItem>) :
    RecyclerView.Adapter<CardColorViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardColorViewHolder {
        return CardColorViewHolder(parent.inflate(R.layout.adapter_card_color, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CardColorViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}