package com.decouikit.atom.menu.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.extensions.inflate
import com.decouikit.atom.menu.holder.SubMenuViewHolder
import com.decouikit.atom.menu.interfaces.OnNavigationItemClickListener
import com.decouikit.atom.menu.model.NavigationItem

class SubMenuAdapter(private var items: List<NavigationItem>) :
    RecyclerView.Adapter<SubMenuViewHolder>() {

    private var onNavigationItemClickListener: OnNavigationItemClickListener? = null

    constructor(
        items: List<NavigationItem>,
        onNavigationItemClickListener: OnNavigationItemClickListener
    )
            : this(items) {
        this.onNavigationItemClickListener = onNavigationItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubMenuViewHolder {
        return SubMenuViewHolder(parent.inflate(R.layout.adapter_sub_menu_item, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SubMenuViewHolder, position: Int) {
        holder.bind(items[position], onNavigationItemClickListener)
    }
}