package com.decouikit.atom.components.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.adapter.NavBlogAdapter
import com.decouikit.atom.components.navigation.interfaces.OnBlogItemClickListener
import com.decouikit.atom.components.navigation.model.NavBlogItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class NavBlogFragment : Fragment(), OnBlogItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<NavBlogItem>
    private lateinit var adapter: NavBlogAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(NAV_BLOG_DATA) ?: arrayListOf()
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

        adapter = NavBlogAdapter(items)
        adapter.setItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }


    override fun onItemClick(item: NavBlogItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(viewLayout.context, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val NAV_BLOG_DATA = "NAV_BLOG_DATA"
        fun newInstance(viewItems: ArrayList<NavBlogItem>): NavBlogFragment {
            val fragment = NavBlogFragment()
            val args = Bundle()
            args.putParcelableArrayList(NAV_BLOG_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}