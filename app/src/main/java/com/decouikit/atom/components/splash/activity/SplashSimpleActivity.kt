package com.decouikit.atom.components.splash.activity

import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.splash.fragment.SplashSimpleFragment
import kotlinx.android.synthetic.main.activity_generic.*

class SplashSimpleActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        callback.invoke(SplashSimpleFragment.newInstance())
        Handler().postDelayed({ finish() }, getSplashScreenDelay())
    }

    override fun loadTag(): String {
        return "SplashSimpleTag"
    }

    private fun getSplashScreenDelay(): Long {
        return 4000L
    }
}