package com.decouikit.atom.components.radio_button.avatar_right.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.radio_button.avatar_right.adapter.RadioButtonAvatarRightAdapter
import com.decouikit.atom.components.radio_button.avatar_right.model.RadioButtonItem
import kotlinx.android.synthetic.main.fragment_content_small_components_list.view.*

class RadioButtonAvatarRightFragment : Fragment() {

    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<RadioButtonItem>
    private lateinit var adapter: RadioButtonAvatarRightAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(ITEM_DATA) ?: arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_content_small_components_list, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        adapter = RadioButtonAvatarRightAdapter(items)
        viewLayout.rvList.layoutManager = LinearLayoutManager(context)
        viewLayout.rvList.adapter = adapter
    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(list: ArrayList<RadioButtonItem>): RadioButtonAvatarRightFragment {
            val fragment = RadioButtonAvatarRightFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            fragment.arguments = args
            return fragment
        }
    }
}