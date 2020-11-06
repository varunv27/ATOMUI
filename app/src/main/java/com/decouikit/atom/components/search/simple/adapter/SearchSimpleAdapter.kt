package com.decouikit.atom.components.search.simple.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.search.simple.holder.SearchSimpleViewHolder
import com.decouikit.atom.components.search.simple.interfaces.OnItemClickListener
import com.decouikit.atom.components.search.simple.model.SearchSimpleItem
import com.decouikit.atom.extensions.inflate

class SearchSimpleAdapter(private var items: ArrayList<SearchSimpleItem>) :
    RecyclerView.Adapter<SearchSimpleViewHolder>() {

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSimpleViewHolder {
        return SearchSimpleViewHolder(parent.inflate(R.layout.adapter_search_item, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SearchSimpleViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }
}