package com.decouikit.atom.components.parallax.shopping.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.parallax.shopping.fragment.ShoppingFragment
import com.decouikit.atom.components.parallax.shopping.model.ShoppingItem
import com.decouikit.atom.components.parallax.shopping.repository.ShoppingRepository
import io.reactivex.rxkotlin.subscribeBy

class ShoppingActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.parallax_shopping))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ShoppingRepository.getData(this).subscribeBy {
            callback.invoke(ShoppingFragment.newInstance(it as ArrayList<ShoppingItem>))
        }
    }

    override fun loadTag(): String {
        return "ParallaxShoppingTag"
    }
}