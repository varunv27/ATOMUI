package com.decouikit.atom.components.toggle.simple.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.toggle.simple.fragment.ToggleSimpleFragment
import com.decouikit.atom.components.toggle.simple.model.ToggleSimpleItem
import com.decouikit.atom.components.toggle.simple.repository.ToggleSimpleRepository
import io.reactivex.rxkotlin.subscribeBy

class ToggleSimpleActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.toggle_simple))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ToggleSimpleRepository.getData(this).subscribeBy {
            callback.invoke(ToggleSimpleFragment.newInstance(it as ArrayList<ToggleSimpleItem>))
        }
    }

    override fun loadTag(): String {
        return "ToggleSimpleTag"
    }
}