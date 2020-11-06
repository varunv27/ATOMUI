package com.decouikit.atom.components.cards.full_image.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.full_image.fragment.CardFullImageFragment
import com.decouikit.atom.components.cards.full_image.model.CardFullImageItem
import com.decouikit.atom.components.cards.full_image.repository.CardFullImageRepository
import io.reactivex.rxkotlin.subscribeBy

class CardFullImageActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.full_image_cards))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CardFullImageRepository.getData(this).subscribeBy {
            callback.invoke(CardFullImageFragment.newInstance(it as ArrayList<CardFullImageItem>))
        }
    }

    override fun loadTag(): String {
        return "CardFullImageTag"
    }
}