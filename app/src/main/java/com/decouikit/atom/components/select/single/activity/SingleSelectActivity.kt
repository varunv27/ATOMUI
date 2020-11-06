package com.decouikit.atom.components.select.single.activity

import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.select.single.fragment.SingleSelectFragment

class SingleSelectActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.single_select))
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(SingleSelectFragment.newInstance())
    }

    override fun loadTag(): String {
        return "SingleSelectTag"
    }
}