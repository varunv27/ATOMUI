package com.decouikit.atom.components.checkbox.icon_left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.checkbox.icon_left.fragment.CheckboxIconLeftFragment
import com.decouikit.atom.components.checkbox.icon_left.model.CheckBoxItem
import com.decouikit.atom.components.checkbox.icon_left.repository.CheckBoxImageRepository
import io.reactivex.rxkotlin.subscribeBy

class CheckboxIconLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.checkbox_icon_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CheckBoxImageRepository.getData(this).subscribeBy {
            callback.invoke(CheckboxIconLeftFragment.newInstance(it as ArrayList<CheckBoxItem>))
        }
    }

    override fun loadTag(): String {
        return "CheckboxIconLeftTag"
    }
}