package com.decouikit.atom.components.toggle.description.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.toggle.description.adapter.ToggleDescAdapter
import com.decouikit.atom.components.toggle.description.model.ToggleDescItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class ToggleDescFragment : Fragment() {

    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<ToggleDescItem>
    private lateinit var adapter: ToggleDescAdapter

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
        adapter = ToggleDescAdapter(items)
        viewLayout.rvList.layoutManager = LinearLayoutManager(context)
        viewLayout.rvList.adapter = adapter
    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(list: ArrayList<ToggleDescItem>): ToggleDescFragment {
            val fragment = ToggleDescFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            fragment.arguments = args
            return fragment
        }
    }
}