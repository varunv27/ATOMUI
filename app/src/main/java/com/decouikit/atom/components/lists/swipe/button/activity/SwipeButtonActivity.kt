package com.decouikit.atom.components.lists.swipe.button.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.lists.swipe.button.fragment.SwipeButtonFragment
import com.decouikit.atom.components.lists.swipe.button.model.SwipeViewItem
import com.decouikit.atom.components.lists.swipe.button.repository.SwipeRepository

class SwipeButtonActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.swipe_button))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        SwipeRepository.getData().subscribe {
            callback.invoke(SwipeButtonFragment.newInstance(it as ArrayList<SwipeViewItem>))
        }
    }

    override fun loadTag(): String {
        return "SwipeButtonListTag"
    }
}
