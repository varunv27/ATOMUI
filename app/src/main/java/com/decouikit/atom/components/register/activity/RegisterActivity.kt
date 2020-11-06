package com.decouikit.atom.components.register.activity

import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.register.fragment.RegisterFragment
import kotlinx.android.synthetic.main.activity_generic.*

class RegisterActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(RegisterFragment.newInstance())
    }

    override fun loadTag(): String {
        return "RegisterTag"
    }
}