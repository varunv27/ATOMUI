package com.decouikit.atom.components.toggle.group.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.toggle.group.fragment.ToggleGroupFragment
import com.decouikit.atom.components.toggle.group.model.ToggleGroupItem
import com.decouikit.atom.components.toggle.group.repository.ToggleGroupRepository
import io.reactivex.rxkotlin.subscribeBy

class ToggleGroupActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.toggle_group))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ToggleGroupRepository.getData(this).subscribeBy {
            callback.invoke(ToggleGroupFragment.newInstance(it as ArrayList<ToggleGroupItem>))
        }
    }

    override fun loadTag(): String {
        return "ToggleGroupTag"
    }
}