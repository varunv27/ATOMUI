package com.decouikit.atom.components.parallax.profile.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.profile.holder.ProfileViewHolder
import com.decouikit.atom.components.parallax.profile.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.profile.model.ProfileListItem
import com.decouikit.atom.extensions.inflate

class ProfileAdapter(private var listItems: ArrayList<ProfileListItem>) :
    RecyclerView.Adapter<ProfileViewHolder>() {

    private var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(parent.inflate(R.layout.adapter_card_styled, false))
    }

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        listener?.let { holder.bind(listItems[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}