package com.decouikit.atom.components.timeline.center.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.timeline.center.fragment.TimelineCenterFragment
import com.decouikit.atom.components.timeline.center.model.TimelineCenterItem
import com.decouikit.atom.components.timeline.center.repository.TimelineCenterRepository

class TimelineCenterActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.timeline_center))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        TimelineCenterRepository.getData(this).subscribe {
            callback.invoke(TimelineCenterFragment.newInstance(it as ArrayList<TimelineCenterItem>))
        }
    }

    override fun loadTag(): String {
        return "TimelineRightTag"
    }
}