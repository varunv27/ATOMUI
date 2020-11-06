package com.decouikit.atom.components.radio_button.icon_right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.radio_button.icon_right.fragment.RadioButtonIconRightFragment
import com.decouikit.atom.components.radio_button.icon_right.model.RadioButtonItem
import com.decouikit.atom.components.radio_button.icon_right.repository.RadioButtonImageRepository
import io.reactivex.rxkotlin.subscribeBy

class RadioButtonIconRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.radiobutton_icon_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        RadioButtonImageRepository.getData(this).subscribeBy {
            callback.invoke(RadioButtonIconRightFragment.newInstance(it as ArrayList<RadioButtonItem>))
        }
    }

    override fun loadTag(): String {
        return "RadioButtonAvatarRightTag"
    }
}