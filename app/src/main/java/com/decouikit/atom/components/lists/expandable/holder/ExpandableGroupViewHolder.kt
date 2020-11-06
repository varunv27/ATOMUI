package com.decouikit.atom.components.lists.expandable.holder

import android.view.View
import android.widget.TextView
import com.decouikit.atom.R
import com.decouikit.atom.util.ExpandableItemIndicator

class ExpandableGroupViewHolder(itemView: View) : ExpandableBaseViewHolder(itemView) {
    var indicator: ExpandableItemIndicator = itemView.findViewById(R.id.indicator)
    var textName: TextView = itemView.findViewById(R.id.tvGroupTitle)
}