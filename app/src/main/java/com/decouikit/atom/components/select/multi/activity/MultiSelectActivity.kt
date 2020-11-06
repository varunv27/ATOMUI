package com.decouikit.atom.components.select.multi.activity

import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.select.multi.fragment.MultiSelectFragment

class MultiSelectActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.multi_select))
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(MultiSelectFragment.newInstance())
    }

    override fun loadTag(): String {
        return "MultiSelectTag"
    }
}