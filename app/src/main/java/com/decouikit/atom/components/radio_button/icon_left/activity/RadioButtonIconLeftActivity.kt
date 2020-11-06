package com.decouikit.atom.components.radio_button.icon_left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.radio_button.icon_left.fragment.RadioButtonIconLeftFragment
import com.decouikit.atom.components.radio_button.icon_left.model.RadioButtonItem
import com.decouikit.atom.components.radio_button.icon_left.repository.RadioButtonImageRepository
import io.reactivex.rxkotlin.subscribeBy

class RadioButtonIconLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.radiobutton_icon_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        RadioButtonImageRepository.getData(this).subscribeBy {
            callback.invoke(RadioButtonIconLeftFragment.newInstance(it as ArrayList<RadioButtonItem>))
        }
    }

    override fun loadTag(): String {
        return "RadioButtonIconLeftTag"
    }
}