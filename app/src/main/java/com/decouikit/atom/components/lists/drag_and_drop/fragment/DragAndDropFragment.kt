package com.decouikit.atom.components.lists.drag_and_drop.fragment

import android.graphics.drawable.NinePatchDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.drag_and_drop.adapter.DragAndDropAdapter
import com.decouikit.atom.components.lists.drag_and_drop.interfaces.OnItemClickListener
import com.decouikit.atom.components.lists.drag_and_drop.model.DragAndDropViewItem
import com.h6ah4i.android.widget.advrecyclerview.animator.DraggableItemAnimator
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class DragAndDropFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<DragAndDropViewItem>

    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private var mRecyclerViewDragDropManager: RecyclerViewDragDropManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(LIST_DRAG_AND_DROP_DATA)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_list, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        mRecyclerViewDragDropManager = RecyclerViewDragDropManager()
        mRecyclerViewDragDropManager?.setDraggingItemShadowDrawable(
            ContextCompat.getDrawable(view.context, R.drawable.material_shadow_z3) as NinePatchDrawable
        )

        mAdapter = DragAndDropAdapter(items)
        (mAdapter as DragAndDropAdapter).setItemClickListener(this)

        mAdapter = mRecyclerViewDragDropManager!!.createWrappedAdapter(mAdapter)      // wrap for dragging

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = mAdapter
        viewLayout.rvList.itemAnimator = DraggableItemAnimator()
        viewLayout.rvList.setHasFixedSize(true)
        mRecyclerViewDragDropManager?.attachRecyclerView(viewLayout.rvList)
    }

    override fun onItemClick(item: DragAndDropViewItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val LIST_DRAG_AND_DROP_DATA = "LIST_DRAG_AND_DROP_DATA"
        fun newInstance(items: ArrayList<DragAndDropViewItem>): DragAndDropFragment {
            val fragment = DragAndDropFragment()
            val args = Bundle()
            args.putParcelableArrayList(LIST_DRAG_AND_DROP_DATA, items)
            fragment.arguments = args
            return fragment
        }
    }
}