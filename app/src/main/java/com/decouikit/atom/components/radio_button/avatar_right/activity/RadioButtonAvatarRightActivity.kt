package com.decouikit.atom.components.radio_button.avatar_right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.radio_button.avatar_right.fragment.RadioButtonAvatarRightFragment
import com.decouikit.atom.components.radio_button.avatar_right.model.RadioButtonItem
import com.decouikit.atom.components.radio_button.avatar_right.repository.RadioButtonImageRepository
import io.reactivex.rxkotlin.subscribeBy

class RadioButtonAvatarRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.radiobutton_avatar_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        RadioButtonImageRepository.getData(this).subscribeBy {
            callback.invoke(RadioButtonAvatarRightFragment.newInstance(it as ArrayList<RadioButtonItem>))
        }
    }

    override fun loadTag(): String {
        return "RadioButtonAvatarRightTag"
    }
}