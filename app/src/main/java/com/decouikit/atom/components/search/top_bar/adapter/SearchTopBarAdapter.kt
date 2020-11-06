package com.decouikit.atom.components.search.top_bar.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.search.top_bar.holder.SearchTopBarViewHolder
import com.decouikit.atom.components.search.top_bar.interfaces.OnItemClickListener
import com.decouikit.atom.components.search.top_bar.model.SearchTopBarItem
import com.decouikit.atom.extensions.inflate

class SearchTopBarAdapter(private var items: ArrayList<SearchTopBarItem>) :
    RecyclerView.Adapter<SearchTopBarViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTopBarViewHolder {
        return SearchTopBarViewHolder(parent.inflate(R.layout.adapter_search_item, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SearchTopBarViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}