package com.decouikit.atom.components.lists.expandable.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.lists.expandable.fragment.ExpandableListFragment
import com.decouikit.atom.components.lists.expandable.model.ExpandableViewItem
import com.decouikit.atom.components.lists.expandable.repository.ExpandableListRepository
import io.reactivex.rxkotlin.subscribeBy

class ExpandableListActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.expandable_list_big_image))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ExpandableListRepository.getData().subscribeBy {
            callback.invoke(ExpandableListFragment.newInstance(it as ArrayList<ExpandableViewItem>))
        }
    }

    override fun loadTag(): String {
        return "ExpandableListTag"
    }
}