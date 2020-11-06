package com.decouikit.atom.components.toggle.description.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.toggle.description.fragment.ToggleDescFragment
import com.decouikit.atom.components.toggle.description.model.ToggleDescItem
import com.decouikit.atom.components.toggle.description.repository.ToggleDescRepository
import io.reactivex.rxkotlin.subscribeBy

class ToggleDescActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.toggle_desc))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ToggleDescRepository.getData(this).subscribeBy {
            callback.invoke(ToggleDescFragment.newInstance(it as ArrayList<ToggleDescItem>))
        }
    }

    override fun loadTag(): String {
        return "ToggleDescTag"
    }
}