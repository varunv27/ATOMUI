package com.decouikit.atom.components.radio_button.avatar_left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.radio_button.avatar_left.fragment.RadioButtonAvatarLeftFragment
import com.decouikit.atom.components.radio_button.avatar_left.model.RadioButtonItem
import com.decouikit.atom.components.radio_button.avatar_left.repository.RadioButtonImageRepository
import io.reactivex.rxkotlin.subscribeBy

class RadioButtonAvatarLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.radiobutton_avatar_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        RadioButtonImageRepository.getData(this).subscribeBy {
            callback.invoke(RadioButtonAvatarLeftFragment.newInstance(it as ArrayList<RadioButtonItem>))
        }
    }

    override fun loadTag(): String {
        return "RadioButtonAvatarLeftTag"
    }
}