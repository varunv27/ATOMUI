package com.decouikit.atom.components.lists.expandable.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.decouikit.atom.R

class ExpandableChildViewHolder(itemView: View) : ExpandableBaseViewHolder(itemView) {
    var tvChildTitle: TextView = itemView.findViewById(R.id.tvChildTitle)
    var ivChildIcon: ImageView = itemView.findViewById(R.id.ivChildIcon)
    var tvChildTag: TextView = itemView.findViewById(R.id.tvChildTag)
}