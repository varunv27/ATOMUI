package com.decouikit.atom.components.timeline.left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.timeline.left.fragment.TimelineLeftFragment
import com.decouikit.atom.components.timeline.left.model.TimelineLeftItem
import com.decouikit.atom.components.timeline.left.repository.TimelineLeftRepository

class TimelineLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.timeline_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        TimelineLeftRepository.getData(this).subscribe {
            callback.invoke(TimelineLeftFragment.newInstance(it as ArrayList<TimelineLeftItem>))
        }
    }

    override fun loadTag(): String {
        return "TimelineLeftTag"
    }
}