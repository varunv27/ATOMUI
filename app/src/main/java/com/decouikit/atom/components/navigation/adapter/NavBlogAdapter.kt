package com.decouikit.atom.components.navigation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.holder.NavBlogViewHolder
import com.decouikit.atom.components.navigation.interfaces.OnBlogItemClickListener
import com.decouikit.atom.components.navigation.model.NavBlogItem
import com.decouikit.atom.extensions.inflate

class NavBlogAdapter(private var items: ArrayList<NavBlogItem>) :
    RecyclerView.Adapter<NavBlogViewHolder>() {

    private var listener: OnBlogItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavBlogViewHolder {
        return NavBlogViewHolder(parent.inflate(R.layout.adapter_card_color, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: NavBlogViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setItemClickListener(listener: OnBlogItemClickListener?) {
        this.listener = listener
    }
}