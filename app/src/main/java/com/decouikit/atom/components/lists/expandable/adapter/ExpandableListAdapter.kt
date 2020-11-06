package com.decouikit.atom.components.lists.expandable.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.expandable.holder.ExpandableChildViewHolder
import com.decouikit.atom.components.lists.expandable.holder.ExpandableGroupViewHolder
import com.decouikit.atom.components.lists.expandable.interfaces.OnExpandableItemClickListener
import com.decouikit.atom.components.lists.expandable.model.ExpandableViewItem
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.utils.RecyclerViewAdapterUtils
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils
import java.util.ArrayList

class ExpandableListAdapter(
    private var items: ArrayList<ExpandableViewItem>,
    private var mExpandableItemManager: RecyclerViewExpandableItemManager,
    private var mOnItemClickListener: OnExpandableItemClickListener
) : AbstractExpandableItemAdapter<ExpandableGroupViewHolder, ExpandableChildViewHolder>(),
    View.OnClickListener {

    init {
        setHasStableIds(true) // this is required for expandable feature.
    }

    override fun getGroupCount(): Int {
        return items.size
    }

    override fun getChildCount(groupPosition: Int): Int {
        return items[groupPosition].subItems?.size!!
    }

    override fun getGroupId(groupPosition: Int): Long {
        // This method need to return unique value within all group items.
        return items[groupPosition].id.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        // This method need to return unique value within the group.
        return items[groupPosition].subItems?.get(childPosition)?.id?.toLong()!!
    }

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): ExpandableGroupViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_expandable_group_item, parent, false)
        val vh = ExpandableGroupViewHolder(v)
        vh.containerView.setOnClickListener(this)
        return vh
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): ExpandableChildViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_expandable_child_item, parent, false)
        val vh = ExpandableChildViewHolder(v)
        vh.containerView.setOnClickListener(this)
        return vh
    }

    override fun onBindGroupViewHolder(
        holder: ExpandableGroupViewHolder,
        groupPosition: Int,
        viewType: Int
    ) {
        val group = items[groupPosition]
        holder.textName.text = group.title

        val expandState = holder.expandState

        if (expandState.isUpdated) {
            val animateIndicator = expandState.hasExpandedStateChanged()

            holder.indicator.setExpandedState(expandState.isExpanded, animateIndicator)
        }
    }

    override fun onBindChildViewHolder(
        holder: ExpandableChildViewHolder,
        groupPosition: Int,
        childPosition: Int,
        viewType: Int
    ) {
        val child = items[groupPosition].subItems?.get(childPosition)
        holder.tvChildTitle.text = child?.title
        holder.ivChildIcon.setImageDrawable(child?.avatarDrawableRes?.let {
            ContextCompat.getDrawable(holder.containerView.context,
                it
            )
        })
        holder.tvChildTag.text = child?.tagName
        child?.tagTextColor?.let {
            ContextCompat.getColor(holder.containerView.context,
                it
            )
        }?.let { holder.tvChildTag.setTextColor(it) }
        holder.tvChildTag.background =
            child?.tagBgRes?.let { ContextCompat.getDrawable(holder.containerView.context, it) }
    }


    override fun onCheckCanExpandOrCollapseGroup(
        holder: ExpandableGroupViewHolder,
        groupPosition: Int,
        x: Int,
        y: Int,
        expand: Boolean
    ): Boolean {
        // handles click event manually (to show SnackBar message)
        return false
    }

    override fun onClick(v: View) {
        val rv = RecyclerViewAdapterUtils.getParentRecyclerView(v)
        val vh = rv!!.findContainingViewHolder(v)

        val rootPosition = vh!!.adapterPosition
        if (rootPosition == RecyclerView.NO_POSITION) {
            return
        }

        // need to determine adapter local flat position like this:
        val rootAdapter = rv.adapter
        val localFlatPosition =
            WrapperAdapterUtils.unwrapPosition(rootAdapter!!, this, rootPosition)

        val expandablePosition = mExpandableItemManager.getExpandablePosition(localFlatPosition)
        val groupPosition =
            RecyclerViewExpandableItemManager.getPackedPositionGroup(expandablePosition)
        val childPosition =
            RecyclerViewExpandableItemManager.getPackedPositionChild(expandablePosition)

        val message: String
        if (childPosition == RecyclerView.NO_POSITION) {
            // Clicked item is a group!

            // toggle expand/collapse
            message = if (mExpandableItemManager.isGroupExpanded(groupPosition)) {
                mExpandableItemManager.collapseGroup(groupPosition)
                "COLLAPSE: Group $groupPosition"
            } else {
                mExpandableItemManager.expandGroup(groupPosition)
                "EXPAND: Group $groupPosition"
            }
        } else {
            // Clicked item is a child!

            message = "CLICKED: Child $groupPosition-$childPosition"
        }

        mOnItemClickListener.onItemClicked(message)
    }
}