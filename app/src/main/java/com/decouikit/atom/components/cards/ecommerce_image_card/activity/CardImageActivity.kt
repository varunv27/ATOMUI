package com.decouikit.atom.components.cards.ecommerce_image_card.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.ecommerce_image_card.fragment.CardImageFragment
import com.decouikit.atom.components.cards.ecommerce_image_card.model.CardImageItem
import com.decouikit.atom.components.cards.ecommerce_image_card.repository.CardImageRepository
import io.reactivex.rxkotlin.subscribeBy

class CardImageActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.cards_image))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CardImageRepository.getData(this).subscribeBy {
            callback.invoke(CardImageFragment.newInstance(it as ArrayList<CardImageItem>))
        }
    }

    override fun loadTag(): String {
        return "CardImageTag"
    }

}