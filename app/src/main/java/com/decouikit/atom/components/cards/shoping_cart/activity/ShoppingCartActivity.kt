package com.decouikit.atom.components.cards.shoping_cart.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.shoping_cart.fragment.ShoppingCartFragment
import com.decouikit.atom.components.cards.shoping_cart.model.ShoppingCartItem
import com.decouikit.atom.components.cards.shoping_cart.repository.ShoppingCartRepository
import io.reactivex.rxkotlin.subscribeBy

class ShoppingCartActivity : GenericActivity() {


    override fun setToolBar() {
        setToolbarTitle(getString(R.string.shopping_cards))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ShoppingCartRepository.getData().subscribeBy {
            callback.invoke(ShoppingCartFragment.newInstance(it as ArrayList<ShoppingCartItem>))
        }
    }

    override fun loadTag(): String {
        return "ShoppingCartTag"
    }
}