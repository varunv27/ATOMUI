package com.decouikit.atom.components.cards.social_color_card.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.social_color_card.adapter.CardColorAdapter
import com.decouikit.atom.components.cards.social_color_card.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.social_color_card.model.CardColorItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class CardColorFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<CardColorItem>
    private lateinit var adapter: CardColorAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_COLOR_DATA) ?: arrayListOf()
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

        adapter = CardColorAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: CardColorItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(viewLayout.context, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val CARD_COLOR_DATA = "CARD_COLOR_DATA"
        fun newInstance(viewItems: ArrayList<CardColorItem>): CardColorFragment {
            val fragment = CardColorFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_COLOR_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}