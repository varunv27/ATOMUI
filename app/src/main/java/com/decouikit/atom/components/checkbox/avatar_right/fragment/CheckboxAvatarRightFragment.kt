package com.decouikit.atom.components.checkbox.avatar_right.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.checkbox.avatar_right.adapter.CheckboxAvatarRightAdapter
import com.decouikit.atom.components.checkbox.avatar_right.model.CheckBoxItem
import kotlinx.android.synthetic.main.fragment_content_small_components_list.view.*

class CheckboxAvatarRightFragment : Fragment() {

    private lateinit var viewLayout: View
    private lateinit var items: ArrayList<CheckBoxItem>
    private lateinit var adapter: CheckboxAvatarRightAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        items = arguments?.getParcelableArrayList(ITEM_DATA) ?: ArrayList()
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
        adapter = CheckboxAvatarRightAdapter(items)
        viewLayout.rvList.layoutManager = LinearLayoutManager(context)
        viewLayout.rvList.adapter = adapter
    }

    companion object {
        private const val ITEM_DATA = "ITEM_DATA"
        fun newInstance(list: ArrayList<CheckBoxItem>): CheckboxAvatarRightFragment {
            val fragment = CheckboxAvatarRightFragment()
            val args = Bundle()
            args.putParcelableArrayList(ITEM_DATA, list)
            fragment.arguments = args
            return fragment
        }
    }
}