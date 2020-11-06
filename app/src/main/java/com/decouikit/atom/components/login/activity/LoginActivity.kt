package com.decouikit.atom.components.login.activity

import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.login.fragment.LoginFragment
import kotlinx.android.synthetic.main.activity_generic.*

class LoginActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(LoginFragment.newInstance())
    }

    override fun loadTag(): String {
        return "LoginTag"
    }
}