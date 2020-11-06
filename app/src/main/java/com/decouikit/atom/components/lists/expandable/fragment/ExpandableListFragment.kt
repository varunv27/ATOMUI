package com.decouikit.atom.components.lists.expandable.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.decouikit.atom.components.lists.expandable.model.ExpandableViewItem
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.expandable.adapter.ExpandableListAdapter
import com.decouikit.atom.components.lists.expandable.interfaces.OnExpandableItemClickListener
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class ExpandableListFragment : Fragment(), OnExpandableItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var items: ArrayList<ExpandableViewItem>
    private lateinit var expItemManager: RecyclerViewExpandableItemManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(LIST_EXPANDABLE_DATA)?: arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_list, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        expItemManager = RecyclerViewExpandableItemManager(null)

        adapter = ExpandableListAdapter(items, expItemManager, this)
        adapter = expItemManager.createWrappedAdapter(adapter)

        viewLayout.rvList.layoutManager = LinearLayoutManager(viewLayout.context)
        viewLayout.rvList.adapter = adapter

        // NOTE: need to disable change animations to ripple effect work properly
        (viewLayout.rvList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

        expItemManager.attachRecyclerView(viewLayout.rvList)
    }

    override fun onItemClicked(message: String) {
        Toast.makeText(viewLayout.context, ""+message, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val LIST_EXPANDABLE_DATA = "LIST_EXPANDABLE_DATA"
        fun newInstance(items: ArrayList<ExpandableViewItem>): ExpandableListFragment {
            val fragment =
                ExpandableListFragment()
            val args = Bundle()
            args.putParcelableArrayList(LIST_EXPANDABLE_DATA, items)
            fragment.arguments = args
            return fragment
        }
    }
}