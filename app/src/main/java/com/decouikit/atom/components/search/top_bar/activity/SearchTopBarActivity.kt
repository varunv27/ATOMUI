package com.decouikit.atom.components.search.top_bar.activity

import android.annotation.SuppressLint
import android.view.View
import androidx.fragment.app.Fragment
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.search.top_bar.fragment.SearchTopBarFragment
import com.decouikit.atom.components.search.top_bar.repository.SearchTopBarRepository
import kotlinx.android.synthetic.main.activity_generic.*

class SearchTopBarActivity : GenericActivity() {

    override fun setToolBar() {
        toolbar.visibility = View.GONE
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        SearchTopBarRepository.getData(this).subscribe {
            callback.invoke(SearchTopBarFragment.newInstance(it))
        }
    }

    override fun loadTag(): String {
        return "SearchSimpleTag"
    }
}