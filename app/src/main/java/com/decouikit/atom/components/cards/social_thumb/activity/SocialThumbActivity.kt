package com.decouikit.atom.components.cards.social_thumb.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.social_thumb.fragment.SocialThumbFragment
import com.decouikit.atom.components.cards.social_thumb.model.SocialThumbItem
import com.decouikit.atom.components.cards.social_thumb.repository.SocialThumbRepository
import io.reactivex.rxkotlin.subscribeBy

class SocialThumbActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.social_thumb_card))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        SocialThumbRepository.getData(this).subscribeBy {
            callback.invoke(SocialThumbFragment.newInstance(it as ArrayList<SocialThumbItem>))
        }
    }

    override fun loadTag(): String {
        return "SocialThumbTag"
    }
}