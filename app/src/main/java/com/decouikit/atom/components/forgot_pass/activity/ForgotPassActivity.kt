package com.decouikit.atom.components.forgot_pass.activity

import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.forgot_pass.fragment.ForgotPassFragment
import kotlinx.android.synthetic.main.activity_generic.*

class ForgotPassActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(ForgotPassFragment.newInstance())
    }

    override fun loadTag(): String {
        return "ForgotPassTag"
    }
}