package com.decouikit.atom.components.parallax.product.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.product.adapter.FriendListAdapter
import com.decouikit.atom.components.parallax.product.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.product.model.FriendListItem
import com.decouikit.atom.components.parallax.product.model.FriendsItem
import kotlinx.android.synthetic.main.fragment_parallax_friends.view.*
import java.util.*

class FriendsFragment : Fragment(), OnItemClickListener, View.OnClickListener {
    private lateinit var viewLayout: View
    private var item: FriendsItem? = null
    private lateinit var adapter: FriendListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(PARALLAX_FRIENDS_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_parallax_friends, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        adapter = FriendListAdapter(item?.viewItems as ArrayList<FriendListItem>)
        adapter.setOnItemClickListener(this)

        viewLayout.tvTag.text = item?.tagName
        viewLayout.tvSubtitle.text = item?.subtitle
        viewLayout.tvTitle.text = item?.title
        viewLayout.tvDesc.text = item?.description
        viewLayout.btnAddToCart.text = item?.buttonText

        viewLayout.rvList.layoutManager = GridLayoutManager(view.context, 2)
        viewLayout.rvList.adapter = adapter

        viewLayout.btnAddToCart.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v) {
            viewLayout.btnAddToCart -> {
                Toast.makeText(viewLayout.context, item?.buttonText, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemClick(item: FriendListItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val PARALLAX_FRIENDS_DATA = "PARALLAX_FRIENDS_DATA"
        fun newInstance(item: FriendsItem): FriendsFragment {
            val fragment = FriendsFragment()
            val args = Bundle()
            args.putParcelable(PARALLAX_FRIENDS_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}