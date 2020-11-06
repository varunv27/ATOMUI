package com.decouikit.atom.components.lists.swipe.button.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.swipe.button.holder.SwipeButtonViewHolder
import com.decouikit.atom.components.lists.swipe.button.interfaces.OnSwipeItemListener
import com.decouikit.atom.components.lists.swipe.button.model.SwipeViewItem
import com.decouikit.atom.extensions.hitTest
import com.decouikit.atom.extensions.inflate
import com.decouikit.atom.util.SharedPrefs
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemConstants
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultAction
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionDefault
import com.h6ah4i.android.widget.advrecyclerview.swipeable.action.SwipeResultActionMoveToSwipedDirection
import kotlinx.android.synthetic.main.adapter_swipe_button_item.view.*

class SwipeButtonAdapter(
    private var items: ArrayList<SwipeViewItem>,
    private var listener: OnSwipeItemListener
) :
    RecyclerView.Adapter<SwipeButtonViewHolder>(),
    SwipeableItemAdapter<SwipeButtonViewHolder> {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeButtonViewHolder {
        return SwipeButtonViewHolder(parent.inflate(R.layout.adapter_swipe_button_item, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SwipeButtonViewHolder, position: Int) {
        holder.bind(items[position], listener, position)

        // Or, it can be specified in pixels instead of proportional value.
        val density = holder.itemView.resources.displayMetrics.density
        val pinnedDistance = density * 120 // 100 dp

        holder.isProportionalSwipeAmountModeEnabled = false
        if (SharedPrefs(holder.itemView.context).isRtlEnabled) {
            holder.maxLeftSwipeAmount = 0f
            holder.maxRightSwipeAmount = pinnedDistance
            holder.swipeItemHorizontalSlideAmount =
                if (items[position].isPinned) pinnedDistance else 0F
        } else {
            holder.maxLeftSwipeAmount = -pinnedDistance
            holder.maxRightSwipeAmount = 0f
            holder.swipeItemHorizontalSlideAmount =
                if (items[position].isPinned) -pinnedDistance else 0F
        }
    }

    override fun onSwipeItem(
        holder: SwipeButtonViewHolder,
        position: Int,
        result: Int
    ): SwipeResultAction? {

        if (SharedPrefs(holder.itemView.context).isRtlEnabled) {
            return when (result) {
                // swipe left --- pin
                SwipeableItemConstants.RESULT_SWIPED_RIGHT -> SwipeLeftResultAction(this, position)
                // other --- do nothing
                SwipeableItemConstants.RESULT_SWIPED_LEFT, SwipeableItemConstants.RESULT_CANCELED -> if (position != RecyclerView.NO_POSITION) {
                    UnpinResultAction(this, position)
                } else {
                    null
                }
                else -> if (position != RecyclerView.NO_POSITION) {
                    UnpinResultAction(this, position)
                } else {
                    null
                }
            }
        } else {
            return when (result) {
                // swipe left --- pin
                SwipeableItemConstants.RESULT_SWIPED_LEFT -> SwipeLeftResultAction(this, position)
                // other --- do nothing
                SwipeableItemConstants.RESULT_SWIPED_RIGHT, SwipeableItemConstants.RESULT_CANCELED -> if (position != RecyclerView.NO_POSITION) {
                    UnpinResultAction(this, position)
                } else {
                    null
                }
                else -> if (position != RecyclerView.NO_POSITION) {
                    UnpinResultAction(this, position)
                } else {
                    null
                }
            }
        }
    }

    override fun onGetSwipeReactionType(
        holder: SwipeButtonViewHolder,
        position: Int,
        x: Int,
        y: Int
    ): Int {
        return if (holder.itemView.container.hitTest(x, y)) {
            SwipeableItemConstants.REACTION_CAN_SWIPE_BOTH_H
        } else {
            SwipeableItemConstants.REACTION_CAN_NOT_SWIPE_BOTH_H
        }
    }

    override fun onSwipeItemStarted(holder: SwipeButtonViewHolder, position: Int) {
        notifyDataSetChanged()
    }

    override fun onSetSwipeBackground(holder: SwipeButtonViewHolder, position: Int, type: Int) {
        if (type == SwipeableItemConstants.DRAWABLE_SWIPE_NEUTRAL_BACKGROUND) {
            holder.itemView.behind_views.visibility = View.GONE
        } else {
            holder.itemView.behind_views.visibility = View.VISIBLE
        }
    }

    private class SwipeLeftResultAction internal constructor(
        private var mAdapter: SwipeButtonAdapter?,
        private val mPosition: Int
    ) :
        SwipeResultActionMoveToSwipedDirection() {
        private var mSetPinned: Boolean = false

        override fun onPerformAction() {
            super.onPerformAction()

            val item = mAdapter!!.items[mPosition]

            if (!item.isPinned) {
                item.isPinned = true
                mAdapter?.notifyItemChanged(mPosition)
                mSetPinned = true
            }
        }

        override fun onSlideAnimationEnd() {
            super.onSlideAnimationEnd()

            if (mSetPinned && mAdapter?.listener != null) {
                mAdapter?.listener?.onItemPinned(mPosition)
            }
        }

        override fun onCleanUp() {
            super.onCleanUp()
            // clear the references
            mAdapter = null
        }
    }

    private class UnpinResultAction internal constructor(
        private var mAdapter: SwipeButtonAdapter?,
        private val mPosition: Int
    ) :
        SwipeResultActionDefault() {

        override fun onPerformAction() {
            super.onPerformAction()

            val item = mAdapter!!.items[mPosition]
            if (item.isPinned) {
                item.isPinned = false
                mAdapter!!.notifyItemChanged(mPosition)
            }
        }

        override fun onCleanUp() {
            super.onCleanUp()
            // clear the references
            mAdapter = null
        }
    }
}