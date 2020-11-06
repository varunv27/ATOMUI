package com.decouikit.atom.components.cards.styled_2.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.styled_2.holder.StyledTwoCardViewHolder
import com.decouikit.atom.components.cards.styled_2.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.styled_2.model.StyledTwoCardItem
import com.decouikit.atom.extensions.inflate

class StyledTwoCardAdapter(private var items: ArrayList<StyledTwoCardItem>) :
    RecyclerView.Adapter<StyledTwoCardViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StyledTwoCardViewHolder {
        return StyledTwoCardViewHolder(parent.inflate(R.layout.adapter_card_styled_two, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StyledTwoCardViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}