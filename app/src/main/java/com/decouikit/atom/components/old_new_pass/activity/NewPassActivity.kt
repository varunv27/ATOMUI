package com.decouikit.atom.components.old_new_pass.activity

import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.old_new_pass.fragment.NewPassFragment
import kotlinx.android.synthetic.main.activity_generic.*

class NewPassActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(NewPassFragment.newInstance())
    }

    override fun loadTag(): String {
        return "NewPassTag"
    }
}