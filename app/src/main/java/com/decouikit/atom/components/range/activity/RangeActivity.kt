package com.decouikit.atom.components.range.activity

import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.range.fragment.RangeFragment

class RangeActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.all))
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(RangeFragment.newInstance())
    }

    override fun loadTag(): String {
        return "RangeTag"
    }
}