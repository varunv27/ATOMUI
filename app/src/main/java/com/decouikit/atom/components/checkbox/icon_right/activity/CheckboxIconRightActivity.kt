package com.decouikit.atom.components.checkbox.icon_right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.checkbox.icon_right.fragment.CheckboxIconRightFragment
import com.decouikit.atom.components.checkbox.icon_right.model.CheckBoxItem
import com.decouikit.atom.components.checkbox.icon_right.repository.CheckBoxImageRepository
import io.reactivex.rxkotlin.subscribeBy

class CheckboxIconRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.checkbox_icon_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CheckBoxImageRepository.getData(this).subscribeBy {
            callback.invoke(CheckboxIconRightFragment.newInstance(it as ArrayList<CheckBoxItem>))
        }
    }

    override fun loadTag(): String {
        return "CheckboxIconRightTag"
    }
}