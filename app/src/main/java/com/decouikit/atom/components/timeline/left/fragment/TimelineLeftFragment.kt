package com.decouikit.atom.components.timeline.left.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.left.adapter.TimelineLeftAdapter
import com.decouikit.atom.components.timeline.left.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.left.model.TimelineLeftItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class TimelineLeftFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<TimelineLeftItem>
    private lateinit var adapter: TimelineLeftAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(ITEM_DATA) ?: ArrayList()
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
        adapter = TimelineLeftAdapter(items)
        adapter.setOnItemClickListener(this)
        viewLayout.rvList.layoutManager = LinearLayoutManager(context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: TimelineLeftItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(list: ArrayList<TimelineLeftItem>): TimelineLeftFragment {
            val fragment = TimelineLeftFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            fragment.arguments = args
            return fragment
        }
    }
}