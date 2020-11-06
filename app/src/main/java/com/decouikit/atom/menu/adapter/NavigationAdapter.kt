package com.decouikit.atom.menu.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.extensions.inflate
import com.decouikit.atom.menu.holder.NavigationHeaderItemViewHolder
import com.decouikit.atom.menu.holder.NavigationItemViewHolder
import com.decouikit.atom.menu.interfaces.OnNavigationItemClickListener
import com.decouikit.atom.menu.model.NavigationAdapterItemType
import com.decouikit.atom.menu.model.NavigationItem

class NavigationAdapter(var items: List<NavigationItem>,
                        private val onNavigationItemClickListener: OnNavigationItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return items[position].itemType.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == NavigationAdapterItemType.HEADER.ordinal) {
            NavigationHeaderItemViewHolder(parent.inflate(R.layout.adapter_navigation_header_item, false))
        } else {
            NavigationItemViewHolder(parent.inflate(R.layout.adapter_navigation_item, false))
        }
    }

    override fun getItemCount() = items.size

    fun setData(items: List<NavigationItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == NavigationAdapterItemType.ITEM.ordinal) {
            (holder as NavigationItemViewHolder).bind(items[position], onNavigationItemClickListener)
        }
    }
}