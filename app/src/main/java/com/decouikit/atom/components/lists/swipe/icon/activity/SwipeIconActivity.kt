package com.decouikit.atom.components.lists.swipe.icon.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.lists.swipe.icon.fragment.SwipeIconFragment
import com.decouikit.atom.components.lists.swipe.icon.model.SwipeViewItem
import com.decouikit.atom.components.lists.swipe.icon.repository.SwipeRepository

class SwipeIconActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.swipe_icons))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        SwipeRepository.getData().subscribe {
            callback.invoke(SwipeIconFragment.newInstance(it as ArrayList<SwipeViewItem>))
        }
    }

    override fun loadTag(): String {
        return "SwipeIconListTag"
    }
}