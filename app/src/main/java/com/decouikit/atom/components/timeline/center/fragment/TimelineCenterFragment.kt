package com.decouikit.atom.components.timeline.center.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.timeline.center.adapter.TimelineCenterAdapter
import com.decouikit.atom.components.timeline.center.interfaces.OnItemClickListener
import com.decouikit.atom.components.timeline.center.model.TimelineCenterItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class TimelineCenterFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<TimelineCenterItem>
    private lateinit var adapter: TimelineCenterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(ITEM_DATA) ?: arrayListOf()
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
        adapter = TimelineCenterAdapter(items)
        adapter.setOnItemClickListener(this)
        viewLayout.rvList.layoutManager = LinearLayoutManager(context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: TimelineCenterItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(list: ArrayList<TimelineCenterItem>): TimelineCenterFragment {
            val fragment = TimelineCenterFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            fragment.arguments = args
            return fragment
        }
    }
}