package com.decouikit.atom.components.checkbox.avatar_right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.checkbox.avatar_right.fragment.CheckboxAvatarRightFragment
import com.decouikit.atom.components.checkbox.avatar_right.model.CheckBoxItem
import com.decouikit.atom.components.checkbox.avatar_right.repository.CheckBoxImageRepository
import io.reactivex.rxkotlin.subscribeBy

class CheckboxAvatarRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.checkbox_avatar_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CheckBoxImageRepository.getData(this).subscribeBy {
            callback.invoke(CheckboxAvatarRightFragment.newInstance(it as ArrayList<CheckBoxItem>))
        }
    }

    override fun loadTag(): String {
        return "CheckboxAvatarRightTag"
    }
}