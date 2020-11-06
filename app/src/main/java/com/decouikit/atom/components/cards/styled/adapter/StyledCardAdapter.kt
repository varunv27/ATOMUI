package com.decouikit.atom.components.cards.styled.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.styled.holder.StyledCardViewHolder
import com.decouikit.atom.components.cards.styled.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.styled.model.StyledCardItem
import com.decouikit.atom.extensions.inflate

class StyledCardAdapter(private var items: ArrayList<StyledCardItem>) :
    RecyclerView.Adapter<StyledCardViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StyledCardViewHolder {
        return StyledCardViewHolder(parent.inflate(R.layout.adapter_card_styled, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StyledCardViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}