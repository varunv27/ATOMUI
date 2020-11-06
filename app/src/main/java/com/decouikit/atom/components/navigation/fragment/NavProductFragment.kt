package com.decouikit.atom.components.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.adapter.NavProductAdapter
import com.decouikit.atom.components.navigation.interfaces.OnProductItemClickListener
import com.decouikit.atom.components.navigation.model.NavProductItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class NavProductFragment : Fragment(), OnProductItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<NavProductItem>
    private lateinit var adapter: NavProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(NAV_PRODUCT_DATA)!!
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

        adapter = NavProductAdapter(items)
        adapter.setItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: NavProductItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onAddClick(item: NavProductItem) {
        item.size++
        adapter.notifyDataSetChanged()
    }

    override fun onRemoveClick(item: NavProductItem) {
        if (item.size > 0) {
            item.size--
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
        const val NAV_PRODUCT_DATA = "NAV_PRODUCT_DATA"
        fun newInstance(viewItems: ArrayList<NavProductItem>): NavProductFragment {
            val fragment = NavProductFragment()
            val args = Bundle()
            args.putParcelableArrayList(NAV_PRODUCT_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}