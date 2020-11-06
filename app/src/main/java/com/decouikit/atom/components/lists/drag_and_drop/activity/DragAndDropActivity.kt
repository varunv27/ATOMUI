package com.decouikit.atom.components.lists.drag_and_drop.activity

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.base.GenericActivity
import com.decouikit.atom.components.lists.drag_and_drop.fragment.DragAndDropFragment
import com.decouikit.atom.components.lists.drag_and_drop.model.DragAndDropViewItem
import com.decouikit.atom.components.lists.drag_and_drop.repository.DragAndDropRepository

class DragAndDropActivity : GenericActivity() {
    override fun setToolBar() {
        setToolbarTitle(getString(R.string.drag_drop))
    }

    @SuppressLint("CheckResult")
    override fun loadFragment(callback: (f: Fragment) -> Unit) {
        DragAndDropRepository.getData().subscribe {
            callback.invoke(DragAndDropFragment.newInstance(it as ArrayList<DragAndDropViewItem>))
        }
    }

    override fun loadTag(): String {
        return "DragAndDropListTag"
    }
}