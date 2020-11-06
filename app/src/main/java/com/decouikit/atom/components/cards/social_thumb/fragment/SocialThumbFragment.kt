package com.decouikit.atom.components.cards.social_thumb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.social_thumb.adapter.SocialThumbAdapter
import com.decouikit.atom.components.cards.social_thumb.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.social_thumb.model.SocialThumbItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class SocialThumbFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<SocialThumbItem>
    private lateinit var adapter: SocialThumbAdapter


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

        adapter = SocialThumbAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: SocialThumbItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(viewLayout.context, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(viewItems: ArrayList<SocialThumbItem>): SocialThumbFragment {
            val fragment = SocialThumbFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}