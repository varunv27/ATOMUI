package com.decouikit.atom.components.search.top_bar.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.search.top_bar.adapter.SearchTopBarAdapter
import com.decouikit.atom.components.search.top_bar.interfaces.OnItemClickListener
import com.decouikit.atom.components.search.top_bar.model.SearchTopBarBaseItem
import com.decouikit.atom.components.search.top_bar.model.SearchTopBarItem
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.fragment_search_top_bar.view.*
import java.util.*

class SearchTopBarFragment : Fragment(), TextWatcher, OnItemClickListener {

    private lateinit var viewLayout: View
    private lateinit var item: SearchTopBarBaseItem
    private lateinit var adapter: SearchTopBarAdapter
    private lateinit var adapterResult: SearchTopBarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(SEARCH_TOP_BAR_DATA) ?: SearchTopBarBaseItem()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_search_top_bar, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        if (SharedPrefs(requireContext()).isRtlEnabled) {
            viewLayout.ivBack.rotation = 180f
        }
        adapter = SearchTopBarAdapter(item.viewItems as ArrayList<SearchTopBarItem>)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter

        viewLayout.etSearch.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable?) {
        val itemListSearch = arrayListOf<SearchTopBarItem>()

        for (item in item.viewItems as ArrayList) {
            if(item.title.toUpperCase(Locale.getDefault()).contains(s.toString().toUpperCase(Locale.getDefault())) ||
                item.subtitle.toUpperCase(Locale.getDefault()).contains(s.toString().toUpperCase(
                    Locale.getDefault()))) {
                itemListSearch.add(item)
            }
        }

        if (s.isNullOrEmpty()) {
            viewLayout.rvList.swapAdapter(adapter, false)
            viewLayout.tvResults.visibility = View.GONE
        } else {
            adapterResult = SearchTopBarAdapter(itemListSearch)
            adapterResult.setOnItemClickListener(this)
            viewLayout.rvList.swapAdapter(adapterResult, false)
            adapter.notifyDataSetChanged()
            viewLayout.tvResults.visibility = View.VISIBLE
            viewLayout.tvResults.text = getString(R.string.search_results, itemListSearch.size)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun onItemClick(item: SearchTopBarItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val SEARCH_TOP_BAR_DATA = "SEARCH_TOP_BAR_DATA"
        fun newInstance(item: SearchTopBarBaseItem): SearchTopBarFragment {
            val fragment = SearchTopBarFragment()
            val args = Bundle()
            args.putParcelable(SEARCH_TOP_BAR_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}