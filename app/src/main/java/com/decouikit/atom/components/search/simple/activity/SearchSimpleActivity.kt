package com.decouikit.atom.components.search.simple.activity

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.search.simple.fragment.SearchSimpleFragment
import com.decouikit.atom.components.search.simple.repository.SearchSimpleRepository
import kotlinx.android.synthetic.main.activity_generic.*

class SearchSimpleActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        SearchSimpleRepository.getData(this).subscribe {
            callback.invoke(SearchSimpleFragment.newInstance(it))
        }
    }

    override fun loadTag(): String {
        return "SearchSimpleTag"
    }
}