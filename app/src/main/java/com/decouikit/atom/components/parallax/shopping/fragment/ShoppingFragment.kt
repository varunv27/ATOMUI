package com.decouikit.atom.components.parallax.shopping.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.shopping.adapter.ShoppingAdapter
import com.decouikit.atom.components.parallax.shopping.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.shopping.model.ShoppingItem
import kotlinx.android.synthetic.main.fragment_parallax_shopping.view.*

class ShoppingFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<ShoppingItem>
    private lateinit var adapter: ShoppingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(PARALLAX_SHOPPING_DATA)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_parallax_shopping, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        adapter = ShoppingAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: ShoppingItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }
    companion object {
        const val PARALLAX_SHOPPING_DATA = "PARALLAX_SHOPPING_DATA"
        fun newInstance(viewItems: ArrayList<ShoppingItem>): ShoppingFragment {
            val fragment = ShoppingFragment()
            val args = Bundle()
            args.putParcelableArrayList(PARALLAX_SHOPPING_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}