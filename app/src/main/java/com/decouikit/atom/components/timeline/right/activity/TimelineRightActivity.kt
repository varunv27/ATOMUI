package com.decouikit.atom.components.timeline.right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.timeline.right.fragment.TimelineRightFragment
import com.decouikit.atom.components.timeline.right.model.TimelineRightItem
import com.decouikit.atom.components.timeline.right.repository.TimelineRightRepository

class TimelineRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.timeline_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        TimelineRightRepository.getData(this).subscribe {
            callback.invoke(TimelineRightFragment.newInstance(it as ArrayList<TimelineRightItem>))
        }
    }

    override fun loadTag(): String {
        return "TimelineRightTag"
    }
}