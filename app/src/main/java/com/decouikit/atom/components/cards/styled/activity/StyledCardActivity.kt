package com.decouikit.atom.components.cards.styled.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.styled.fragment.StyledCardFragment
import com.decouikit.atom.components.cards.styled.model.StyledCardItem
import com.decouikit.atom.components.cards.styled.repository.StyledCardRepository
import io.reactivex.rxkotlin.subscribeBy

class StyledCardActivity : GenericActivity() {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.styled_cards))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        StyledCardRepository.getData(this).subscribeBy {
            callback.invoke(StyledCardFragment.newInstance(it as ArrayList<StyledCardItem>))
        }
    }

    override fun loadTag(): String {
        return "StyledCardTag"
    }
}