package com.decouikit.atom.components.rtl_color_change.activity

import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.rtl_color_change.fragment.RtlColorChangeFragment

class RtlColorChangeActivity : GenericActivity() {
    override fun setToolBar() {
        setToolbarTitle(getString(R.string.rtl_test))
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(RtlColorChangeFragment.newInstance())
    }

    override fun loadTag(): String {
        return "RtlColorChangeTag"
    }
}