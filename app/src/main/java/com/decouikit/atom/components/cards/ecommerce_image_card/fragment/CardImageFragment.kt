package com.decouikit.atom.components.cards.ecommerce_image_card.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.ecommerce_image_card.adapter.CardImageAdapter
import com.decouikit.atom.components.cards.ecommerce_image_card.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.ecommerce_image_card.model.CardImageItem
import kotlinx.android.synthetic.main.fragment_content_grid_list.view.*

class CardImageFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<CardImageItem>
    private lateinit var adapter: CardImageAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_IMAGE_DATA)?: arrayListOf()
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

        adapter = CardImageAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = GridLayoutManager(context, 2)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: CardImageItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val CARD_IMAGE_DATA = "CARD_IMAGE_DATA"
        fun newInstance(viewItems: ArrayList<CardImageItem>): CardImageFragment {
            val fragment = CardImageFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_IMAGE_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}