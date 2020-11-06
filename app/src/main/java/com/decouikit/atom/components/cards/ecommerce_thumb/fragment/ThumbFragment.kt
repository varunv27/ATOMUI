package com.decouikit.atom.components.cards.ecommerce_thumb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_thumb.adapter.ThumbAdapter
import com.decouikit.atom.components.cards.ecommerce_thumb.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_thumb.model.ThumbItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class ThumbFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<ThumbItem>
    private lateinit var adapter: ThumbAdapter


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

        adapter = ThumbAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: ThumbItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(viewItems: ArrayList<ThumbItem>): ThumbFragment {
            val fragment = ThumbFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}