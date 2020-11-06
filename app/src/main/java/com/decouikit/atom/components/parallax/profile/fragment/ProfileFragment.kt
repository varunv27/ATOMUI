package com.decouikit.atom.components.parallax.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.parallax.profile.adapter.ProfileAdapter
import com.decouikit.atom.components.parallax.profile.interfaces.OnItemClickListener
import com.decouikit.atom.components.parallax.profile.model.ProfileBaseItem
import com.decouikit.atom.components.parallax.profile.model.ProfileListItem
import kotlinx.android.synthetic.main.fragment_parallax_profile.view.*

class ProfileFragment : Fragment(), OnItemClickListener, View.OnClickListener {

    private lateinit var viewLayout: View

    private var item: ProfileBaseItem? = null
    private lateinit var adapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(PARALLAX_PROFILE_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_parallax_profile, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        viewLayout.tvItemTitle.text = item?.title
        viewLayout.tvItemSubtitle.text = item?.subtitle
        viewLayout.btnFollow.text = item?.button1Text
        viewLayout.btnMessage.text = item?.button2Text
        viewLayout.ivAvatarItem.setImageDrawable(item?.avatarDrawableRes?.let {
            ContextCompat.getDrawable(viewLayout.context,
                it
            )
        })

        adapter = ProfileAdapter(item?.viewItems as ArrayList<ProfileListItem>)
        adapter.setOnItemClickListener(this)

        viewLayout.rvList.layoutManager = LinearLayoutManager(view.context)
        viewLayout.rvList.adapter = adapter

        viewLayout.btnFollow.setOnClickListener(this)
        viewLayout.btnMessage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            viewLayout.btnFollow -> {
                Toast.makeText(viewLayout.context, item?.button1Text, Toast.LENGTH_SHORT).show()
            }
            viewLayout.btnMessage -> {
                Toast.makeText(viewLayout.context, item?.button2Text, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onItemClick(item: ProfileListItem) {
        Toast.makeText(viewLayout.context, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(viewLayout.context, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val PARALLAX_PROFILE_DATA = "PARALLAX_PROFILE_DATA"
        fun newInstance(item: ProfileBaseItem): ProfileFragment {
            val fragment = ProfileFragment()
            val args = Bundle()
            args.putParcelable(PARALLAX_PROFILE_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }

}