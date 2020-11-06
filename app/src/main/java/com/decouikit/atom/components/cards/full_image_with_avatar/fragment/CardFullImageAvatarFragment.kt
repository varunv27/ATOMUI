package com.decouikit.atom.components.cards.full_image_with_avatar.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.cards.full_image_with_avatar.adapter.CardFullImageAvatarAdapter
import com.decouikit.atom.components.cards.full_image_with_avatar.interfaces.OnItemClickListener
import com.decouikit.atom.components.cards.full_image_with_avatar.model.CardFullImageAvatarItem
import kotlinx.android.synthetic.main.fragment_content_list.view.*

class CardFullImageAvatarFragment : Fragment(), OnItemClickListener {

    private lateinit var viewLayout: View

    private lateinit var items: ArrayList<CardFullImageAvatarItem>
    private lateinit var adapter: CardFullImageAvatarAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(CARD_FULL_IMAGE_AVATAR_DATA) ?: arrayListOf()
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

        adapter = CardFullImageAvatarAdapter(items)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter
    }

    override fun onItemClick(item: CardFullImageAvatarItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onButtonClick() {
        Toast.makeText(viewLayout.context, R.string.on_button_click, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val CARD_FULL_IMAGE_AVATAR_DATA = "CARD_FULL_IMAGE_AVATAR_DATA"
        fun newInstance(viewItems: ArrayList<CardFullImageAvatarItem>): CardFullImageAvatarFragment {
            val fragment = CardFullImageAvatarFragment()
            val args = Bundle()
            args.putParcelableArrayList(CARD_FULL_IMAGE_AVATAR_DATA, viewItems)
            fragment.arguments = args
            return fragment
        }
    }
}