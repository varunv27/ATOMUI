package com.decouikit.atom.components.cards.styled_2.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.cards.styled_2.fragment.StyledTwoCardFragment
import com.decouikit.atom.components.cards.styled_2.model.StyledTwoCardItem
import com.decouikit.atom.components.cards.styled_2.repository.StyledTwoCardRepository
import io.reactivex.rxkotlin.subscribeBy

class StyledTwoCardActivity : GenericActivity()  {

    override fun setToolBar() {
        setToolbarTitle(getString(R.string.styled_cards_3))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        StyledTwoCardRepository.getData(this).subscribeBy {
            callback.invoke(StyledTwoCardFragment.newInstance(it as ArrayList<StyledTwoCardItem>))
        }
    }

    override fun loadTag(): String {
        return "StyledCardTwoTag"
    }
}