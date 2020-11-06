package com.decouikit.atom.components.cards.social_color_card.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.social_color_card.fragment.CardColorFragment
import com.decouikit.atom.components.cards.social_color_card.model.CardColorItem
import com.decouikit.atom.components.cards.social_color_card.repository.CardColorRepository
import io.reactivex.rxkotlin.subscribeBy

class CardColorActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.cards_social))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CardColorRepository.getData(this).subscribeBy {
            callback.invoke(CardColorFragment.newInstance(it as ArrayList<CardColorItem>))
        }
    }

    override fun loadTag(): String {
        return "CardColorTag"
    }
}