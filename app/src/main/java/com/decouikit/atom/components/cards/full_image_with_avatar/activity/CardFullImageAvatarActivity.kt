package com.decouikit.atom.components.cards.full_image_with_avatar.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.full_image_with_avatar.fragment.CardFullImageAvatarFragment
import com.decouikit.atom.components.cards.full_image_with_avatar.model.CardFullImageAvatarItem
import com.decouikit.atom.components.cards.full_image_with_avatar.repository.CardFullImageAvatarRepository
import io.reactivex.rxkotlin.subscribeBy

class CardFullImageAvatarActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.full_cards_avatar))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        CardFullImageAvatarRepository.getData(this).subscribeBy {
            callback.invoke(CardFullImageAvatarFragment.newInstance(it as ArrayList<CardFullImageAvatarItem>))
        }
    }

    override fun loadTag(): String {
        return "CardFullImageAvatarTag"
    }
}