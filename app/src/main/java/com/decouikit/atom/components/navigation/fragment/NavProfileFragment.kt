package com.decouikit.atom.components.navigation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.adapter.NavProfileAdapter
import com.decouikit.atom.components.navigation.interfaces.OnProfileItemClickListener
import com.decouikit.atom.components.navigation.model.NavProfileItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class NavProfileFragment : Fragment(), OnProfileItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<NavProfileItem>
    private lateinit var adapter: NavProfileAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(NAV_PROFILE_DATA) ?: arrayListOf()
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

        adapter = NavProfileAdapter(items)
        adapter.setItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: NavProfileItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val NAV_PROFILE_DATA = "CARD_STYLED_DATA"
        fun newInstance(viewItems: ArrayList<NavProfileItem>): NavProfileFragment {
            val fragment = NavProfileFragment()
            val args = Bundle()
            args.putParcelableArrayList(NAV_PROFILE_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}