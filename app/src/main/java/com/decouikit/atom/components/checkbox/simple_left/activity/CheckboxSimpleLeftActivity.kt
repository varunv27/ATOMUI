package com.decouikit.atom.components.checkbox.simple_left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.checkbox.simple_left.fragment.CheckboxSimpleLeftFragment
import com.decouikit.atom.components.checkbox.simple_left.model.CheckBoxItem
import com.decouikit.atom.components.checkbox.simple_left.repository.CheckBoxSimpleRepository
import io.reactivex.rxkotlin.subscribeBy

class CheckboxSimpleLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.checkbox_simple_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CheckBoxSimpleRepository.getData(this).subscribeBy {
            callback.invoke(CheckboxSimpleLeftFragment.newInstance(it as ArrayList<CheckBoxItem>))
        }
    }

    override fun loadTag(): String {
        return "CheckboxSimpleLeftTag"
    }
}