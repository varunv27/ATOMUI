package com.decouikit.atom.components.checkbox.simple_right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.checkbox.simple_right.fragment.CheckboxSimpleRightFragment
import com.decouikit.atom.components.checkbox.simple_right.model.CheckBoxItem
import com.decouikit.atom.components.checkbox.simple_right.repository.CheckBoxSimpleRepository
import io.reactivex.rxkotlin.subscribeBy

class CheckboxSimpleRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.checkbox_simple_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CheckBoxSimpleRepository.getData(this).subscribeBy {
            callback.invoke(CheckboxSimpleRightFragment.newInstance(it as ArrayList<CheckBoxItem>))
        }
    }

    override fun loadTag(): String {
        return "CheckboxSimpleRightTag"
    }
}