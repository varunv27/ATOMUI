package com.decouikit.atom.components.cards.social_thumb.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.social_thumb.holder.SocialThumbViewHolder
import com.decouikit.atom.components.cards.social_thumb.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.social_thumb.model.SocialThumbItem
import com.decouikit.atom.extensions.inflate

class SocialThumbAdapter(private var items: ArrayList<SocialThumbItem>) :
    RecyclerView.Adapter<SocialThumbViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SocialThumbViewHolder {
        return SocialThumbViewHolder(parent.inflate(R.layout.adapter_card_social_thumb, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SocialThumbViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}