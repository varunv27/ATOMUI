package com.decouikit.atom.components.cards.ecommerce_category.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_category.holder.CardCategoryViewHolder
import com.decouikit.atom.components.cards.ecommerce_category.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_category.model.CardCategoryItem
import com.decouikit.atom.extensions.inflate

class CardCategoryAdapter(private var items: ArrayList<CardCategoryItem>) :
    RecyclerView.Adapter<CardCategoryViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardCategoryViewHolder {
        return CardCategoryViewHolder(parent.inflate(R.layout.adapter_card_category, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CardCategoryViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}