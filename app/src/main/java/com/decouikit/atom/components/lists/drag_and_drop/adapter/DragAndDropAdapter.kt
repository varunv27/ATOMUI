package com.decouikit.atom.components.lists.drag_and_drop.adapter

import android.annotation.TargetApi
import android.os.Build
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.drag_and_drop.holder.DragAndDropViewHolder
import com.decouikit.atom.components.lists.drag_and_drop.interfaces.OnItemClickListener
import com.decouikit.atom.components.lists.drag_and_drop.model.DragAndDropViewItem
import com.decouikit.atom.extensions.hitTest
import com.decouikit.atom.extensions.inflate
import com.decouikit.atom.util.DrawableUtils
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemConstants
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange
import kotlinx.android.synthetic.main.adapter_list_drag_and_drop_item.view.*
import java.util.*

class DragAndDropAdapter(private var items: ArrayList<DragAndDropViewItem>) :
    RecyclerView.Adapter<DragAndDropViewHolder>(),
    DraggableItemAdapter<DragAndDropViewHolder> {

    private var listener: OnItemClickListener? = null

    init {
        setHasStableIds(true)
    }

    fun setItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragAndDropViewHolder {
        return DragAndDropViewHolder(
            parent.inflate(
                R.layout.adapter_list_drag_and_drop_item,
                false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    @TargetApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: DragAndDropViewHolder, position: Int) {
        listener?.let { holder.bind(items[position], it) }

        val dragState = holder.dragStateFlags
        if (dragState and DraggableItemConstants.STATE_FLAG_IS_UPDATED != 0) {
            when {
                dragState and DraggableItemConstants.STATE_FLAG_IS_ACTIVE != 0 -> {

                    holder.itemView.ivDraggable.setBackgroundResource(R.drawable.ic_drag)
                    // need to clear drawable state here to get correct appearance of the dragging item.
                    DrawableUtils.clearState(holder.itemView.container.foreground)
                }
                dragState and DraggableItemConstants.STATE_FLAG_DRAGGING != 0 -> holder.itemView.ivDraggable.setBackgroundResource(
                    R.drawable.ic_drag
                )
                else -> holder.itemView.ivDraggable.setBackgroundResource(R.drawable.ic_drag)
            }
        }
    }

    override fun onGetItemDraggableRange(
        holder: DragAndDropViewHolder,
        position: Int
    ): ItemDraggableRange? {
        // no drag-sortable range specified
        return null
    }

    override fun onCheckCanStartDrag(
        holder: DragAndDropViewHolder,
        position: Int,
        x: Int,
        y: Int
    ): Boolean {
        // x, y --- relative from the itemView's top-left
        val offsetX =
            holder.itemView.container.left + (holder.itemView.container.translationX + 0.5f).toInt()
        val offsetY =
            holder.itemView.container.top + (holder.itemView.container.translationY + 0.5f).toInt()

        return holder.itemView.drag_handle.hitTest(x - offsetX, y - offsetY)
    }

    override fun onItemDragStarted(position: Int) {
        notifyDataSetChanged()
    }

    override fun onMoveItem(fromPosition: Int, toPosition: Int) {
        if (fromPosition == toPosition) {
            return
        }
        val item = items[fromPosition]
        items.removeAt(fromPosition)
        items.add(toPosition, item)
        notifyDataSetChanged()
    }

    override fun onCheckCanDrop(draggingPosition: Int, dropPosition: Int): Boolean {
        return true
    }

    override fun onItemDragFinished(fromPosition: Int, toPosition: Int, result: Boolean) {
        notifyDataSetChanged()
    }
}