package com.decouikit.atom.components.radio_button.simple_right.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.radio_button.simple_right.fragment.RadioButtonSimpleRightFragment
import com.decouikit.atom.components.radio_button.simple_right.model.RadioButtonItem
import com.decouikit.atom.components.radio_button.simple_right.repository.RadioButtonSimpleRepository
import io.reactivex.rxkotlin.subscribeBy

class RadioButtonSimpleRightActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.radiobutton_simple_right))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        RadioButtonSimpleRepository.getData(this).subscribeBy {
            callback.invoke(RadioButtonSimpleRightFragment.newInstance(it as ArrayList<RadioButtonItem>))
        }
    }

    override fun loadTag(): String {
        return "RadioButtonSimpleRightTag"
    }
}