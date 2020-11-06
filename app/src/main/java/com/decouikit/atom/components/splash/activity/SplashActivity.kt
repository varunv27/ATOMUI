package com.decouikit.atom.components.splash.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.splash.fragment.SplashFragment
import com.decouikit.atom.components.splash.repository.SplashRepository
import com.decouikit.atom.components.base.WizardActivity
import com.decouikit.atom.menu.activity.NavigationActivity
import com.decouikit.atom.util.SharedPrefs
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_generic.*

class SplashActivity : GenericActivity() {
    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    private val prefs: SharedPrefs by lazy {
        SharedPrefs(this)
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        SplashRepository.getData(this).subscribeBy {
            callback.invoke(SplashFragment.newInstance(it))
        }
        Handler().postDelayed({ closeSplashScreen() }, getSplashScreenDelay())
    }

    override fun loadTag(): String {
        return "SplashScreenTag"
    }

    private fun getSplashScreenDelay(): Long {
        return 4000L
    }

    private fun closeSplashScreen() {
        if (prefs.isWizardVisible) {
            startActivity(Intent(this, WizardActivity::class.java))
        } else {
            startActivity(Intent(this, NavigationActivity::class.java))
        }
        finish()
    }

}