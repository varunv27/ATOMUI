package com.decouikit.atom.components.checkbox.avatar_left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.checkbox.avatar_left.fragment.CheckboxAvatarLeftFragment
import com.decouikit.atom.components.checkbox.avatar_left.model.CheckBoxItem
import com.decouikit.atom.components.checkbox.avatar_left.repository.CheckBoxImageRepository
import io.reactivex.rxkotlin.subscribeBy

class CheckboxAvatarLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.checkbox_avatar_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CheckBoxImageRepository.getData(this).subscribeBy {
            callback.invoke(CheckboxAvatarLeftFragment.newInstance(it as ArrayList<CheckBoxItem>))
        }
    }

    override fun loadTag(): String {
        return "CheckboxAvatarLeftTag"
    }
}