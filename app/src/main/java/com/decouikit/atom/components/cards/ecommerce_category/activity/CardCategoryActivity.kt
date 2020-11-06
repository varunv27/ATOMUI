package com.decouikit.atom.components.cards.ecommerce_category.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.ecommerce_category.fragment.CardCategoryFragment
import com.decouikit.atom.components.cards.ecommerce_category.model.CardCategoryItem
import com.decouikit.atom.components.cards.ecommerce_category.repository.CardCategoryRepository
import io.reactivex.rxkotlin.subscribeBy

class CardCategoryActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.cards_category))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CardCategoryRepository.getData(this).subscribeBy {
            callback.invoke(CardCategoryFragment.newInstance(it as ArrayList<CardCategoryItem>))
        }
    }

    override fun loadTag(): String {
        return "CardCategoryTag"
    }

}