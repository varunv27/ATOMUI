package com.decouikit.atom.components.search.simple.fragment

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
import com.decouikit.atom.components.search.simple.adapter.SearchSimpleAdapter
import com.decouikit.atom.components.search.simple.interfaces.OnItemClickListener
import com.decouikit.atom.components.search.simple.model.SearchSimpleBaseItem
import com.decouikit.atom.components.search.simple.model.SearchSimpleItem
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.fragment_search_simple.view.*
import java.util.*

class SearchSimpleFragment : Fragment(), TextWatcher, OnItemClickListener {

    private lateinit var viewLayout: View
    private lateinit var item: SearchSimpleBaseItem
    private lateinit var adapter: SearchSimpleAdapter
    private lateinit var adapterResult: SearchSimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(SEARCH_SIMPLE_DATA) ?: SearchSimpleBaseItem()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_search_simple, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        if (SharedPrefs(requireContext()).isRtlEnabled) {
            viewLayout.ivBack.rotation = 180f
        }
        adapter = SearchSimpleAdapter(item.viewItems as ArrayList<SearchSimpleItem>)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter

        viewLayout.etSearch.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable?) {
        val itemListSearch = arrayListOf<SearchSimpleItem>()

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
            adapterResult = SearchSimpleAdapter(itemListSearch)
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

    override fun onItemClick(item: SearchSimpleItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val SEARCH_SIMPLE_DATA = "SEARCH_SIMPLE_DATA"
        fun newInstance(item: SearchSimpleBaseItem): SearchSimpleFragment {
            val fragment = SearchSimpleFragment()
            val args = Bundle()
            args.putParcelable(SEARCH_SIMPLE_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}