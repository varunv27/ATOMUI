package com.decouikit.atom.menu.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.menu.interfaces.OnNavigationItemClickListener
import com.decouikit.atom.menu.model.NavigationItem
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.adapter_sub_menu_item.view.*

class SubMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var view: View = itemView
    private lateinit var item: NavigationItem
    private var onNavigationItemClickListener: OnNavigationItemClickListener? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(item: NavigationItem, onNavigationItemClickListener: OnNavigationItemClickListener?) {
        this.item = item
        this.onNavigationItemClickListener = onNavigationItemClickListener

        view.tvItemTitle.text = item.title
        if (SharedPrefs(itemView.context).isRtlEnabled) {
            itemView.ivItem.rotation = 180f
        }
    }

    override fun onClick(v: View) {
        this.onNavigationItemClickListener?.onNavigationItemClick(v, item)
    }
}