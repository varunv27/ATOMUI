package com.decouikit.atom.components.small_components.activity

import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.small_components.fragment.SmallComponentsFragment

class SmallComponentsActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.all))
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(SmallComponentsFragment.newInstance())
    }

    override fun loadTag(): String {
        return "SmallComponentsTag"
    }
}