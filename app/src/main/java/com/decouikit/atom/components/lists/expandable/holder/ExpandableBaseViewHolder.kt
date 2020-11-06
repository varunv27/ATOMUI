package com.decouikit.atom.components.lists.expandable.holder

import android.view.View
import com.decouikit.atom.R
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder

abstract class ExpandableBaseViewHolder(itemView: View) :
    AbstractExpandableItemViewHolder(itemView) {
    var containerView: View = itemView.findViewById(R.id.container)
}