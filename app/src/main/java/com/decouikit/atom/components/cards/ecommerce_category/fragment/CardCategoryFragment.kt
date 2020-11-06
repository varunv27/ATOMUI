package com.decouikit.atom.components.cards.ecommerce_category.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_category.adapter.CardCategoryAdapter
import com.decouikit.atom.components.cards.ecommerce_category.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_category.model.CardCategoryItem
import kotlinx.android.synthetic.main.fragment_content_grid_list.view.*

class CardCategoryFragment : Fragment(), OnItemClickListener {
    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<CardCategoryItem>
    private lateinit var adapter: CardCategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_CATEGORY_DATA) ?: arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_grid_list, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        adapter = CardCategoryAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = GridLayoutManager(context, 2)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: CardCategoryItem) {
        Toast.makeText(viewLayout.context, item.subtitle, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val CARD_CATEGORY_DATA = "CARD_CATEGORY_DATA"
        fun newInstance(viewItems: ArrayList<CardCategoryItem>): CardCategoryFragment {
            val fragment = CardCategoryFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_CATEGORY_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}