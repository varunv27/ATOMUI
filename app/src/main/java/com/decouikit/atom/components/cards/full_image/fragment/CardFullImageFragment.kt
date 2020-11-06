package com.decouikit.atom.components.cards.full_image.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image.adapter.CardFullImageAdapter
import com.decouikit.atom.components.cards.full_image.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.full_image.model.CardFullImageItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class CardFullImageFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<CardFullImageItem>
    private lateinit var adapter: CardFullImageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_FULL_IMAGE_DATA)?: arrayListOf()
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

        adapter = CardFullImageAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: CardFullImageItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(viewLayout.context, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val CARD_FULL_IMAGE_DATA = "CARD_FULL_IMAGE_DATA"
        fun newInstance(viewItems: ArrayList<CardFullImageItem>): CardFullImageFragment {
            val fragment = CardFullImageFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_FULL_IMAGE_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}