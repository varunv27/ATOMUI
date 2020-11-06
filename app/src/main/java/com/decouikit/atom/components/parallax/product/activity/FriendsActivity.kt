package com.decouikit.atom.components.parallax.product.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.parallax.product.fragment.FriendsFragment
import com.decouikit.atom.components.parallax.product.repository.FriendsRepository
import io.reactivex.rxkotlin.subscribeBy

class FriendsActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.parallax_friends))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        FriendsRepository.getData(this).subscribeBy {
            callback.invoke(FriendsFragment.newInstance(it))
        }
    }

    override fun loadTag(): String {
        return "ParallaxFriendsTag"
    }
}