package com.decouikit.atom.components.parallax.profile.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.parallax.profile.fragment.ProfileFragment
import com.decouikit.atom.components.parallax.profile.repository.ProfileRepository
import io.reactivex.rxkotlin.subscribeBy

class ProfileActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.parallax_profile))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ProfileRepository.getData(this).subscribeBy {
            callback.invoke(ProfileFragment.newInstance(it))
        }
    }

    override fun loadTag(): String {
        return "ParallaxProfileTag"
    }
}