package com.decouikit.atom.components.cards.shoping_cart.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.shoping_cart.adapter.ShoppingCartAdapter
import com.decouikit.atom.components.cards.shoping_cart.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.shoping_cart.model.ShoppingCartItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class ShoppingCartFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<ShoppingCartItem>
    private lateinit var adapter: ShoppingCartAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_SHOPPING_CART_DATA) ?: arrayListOf()
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

        adapter = ShoppingCartAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: ShoppingCartItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onAddClick(item: ShoppingCartItem) {
        item.size++
        adapter.notifyDataSetChanged()
    }

    override fun onRemoveClick(item: ShoppingCartItem) {
        if (item.size > 0) {
            item.size--
            adapter.notifyDataSetChanged()
        }
    }

    companion object {
        const val CARD_SHOPPING_CART_DATA = "CARD_SHOPPING_CART_DATA"
        fun newInstance(viewItems: ArrayList<ShoppingCartItem>): ShoppingCartFragment {
            val fragment = ShoppingCartFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_SHOPPING_CART_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}