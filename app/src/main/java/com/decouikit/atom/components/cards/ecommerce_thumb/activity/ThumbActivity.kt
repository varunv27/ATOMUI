package com.decouikit.atom.components.cards.ecommerce_thumb.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.ecommerce_thumb.fragment.ThumbFragment
import com.decouikit.atom.components.cards.ecommerce_thumb.model.ThumbItem
import com.decouikit.atom.components.cards.ecommerce_thumb.repository.ThumbRepository
import io.reactivex.rxkotlin.subscribeBy

class ThumbActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.e_commerce_thumb))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        ThumbRepository.getData(this).subscribeBy {
            callback.invoke(ThumbFragment.newInstance(it as ArrayList<ThumbItem>))
        }
    }

    override fun loadTag(): String {
        return "ThumbTag"
    }
}