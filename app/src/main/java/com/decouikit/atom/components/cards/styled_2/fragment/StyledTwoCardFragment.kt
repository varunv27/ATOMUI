package com.decouikit.atom.components.cards.styled_2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.styled_2.adapter.StyledTwoCardAdapter
import com.decouikit.atom.components.cards.styled_2.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.styled_2.model.StyledTwoCardItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class StyledTwoCardFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<StyledTwoCardItem>
    private lateinit var adapter: StyledTwoCardAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_STYLED_TWO_DATA) ?: arrayListOf()
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

        adapter = StyledTwoCardAdapter(items)
        adapter.setItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: StyledTwoCardItem) {
        Toast.makeText(viewLayout.context, item.title ,Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val CARD_STYLED_TWO_DATA = "CARD_STYLED_DATA"
        fun newInstance(viewItems: ArrayList<StyledTwoCardItem>): StyledTwoCardFragment {
            val fragment = StyledTwoCardFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_STYLED_TWO_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}