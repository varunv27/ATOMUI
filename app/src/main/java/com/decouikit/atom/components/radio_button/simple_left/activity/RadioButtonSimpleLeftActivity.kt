package com.decouikit.atom.components.radio_button.simple_left.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.radio_button.simple_left.fragment.RadioButtonSimpleLeftFragment
import com.decouikit.atom.components.radio_button.simple_left.model.RadioButtonItem
import com.decouikit.atom.components.radio_button.simple_left.repository.RadioButtonSimpleRepository
import io.reactivex.rxkotlin.subscribeBy

class RadioButtonSimpleLeftActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.radiobutton_simple_left))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        RadioButtonSimpleRepository.getData(this).subscribeBy {
            callback.invoke(RadioButtonSimpleLeftFragment.newInstance(it as ArrayList<RadioButtonItem>))
        }
    }

    override fun loadTag(): String {
        return "RadioButtonSimpleLeftTag"
    }
}