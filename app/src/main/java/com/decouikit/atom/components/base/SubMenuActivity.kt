package com.decouikit.atom.components.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.lists.drag_and_drop.activity.DragAndDropActivity
import com.decouikit.atom.components.lists.expandable.activity.ExpandableListActivity
import com.decouikit.atom.components.lists.swipe.button.activity.SwipeButtonActivity
import com.decouikit.atom.components.lists.swipe.icon.activity.SwipeIconActivity
import com.decouikit.atom.menu.adapter.SubMenuAdapter
import com.decouikit.atom.menu.interfaces.OnNavigationItemClickListener
import com.decouikit.atom.menu.model.NavigationItem
import com.decouikit.atom.menu.model.NavigationItemType
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.activity_sub_menu.*

class SubMenuActivity : AppCompatActivity(), View.OnClickListener, OnNavigationItemClickListener {

    private var item: NavigationItem? = null
    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(R.layout.activity_sub_menu)
        supportActionBar?.hide()

        initLayout()
        initListeners()
    }

    private fun initLayout() {
        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.parent)

        item = intent.getParcelableExtra("NAVIGATION_ITEM")

        toolbarTitle.text = item?.title
        rvSubMenu.layoutManager = LinearLayoutManager(this)
        rvSubMenu.adapter = SubMenuAdapter(item?.navigationList as ArrayList, this)
    }

    private fun getLayoutDirection(): Int {
        return if (prefs.isRtlEnabled) {
            ivBack.rotation = 180f
            ViewCompat.LAYOUT_DIRECTION_RTL
        }
        else {
            ViewCompat.LAYOUT_DIRECTION_LOCALE
        }
    }

    private fun initListeners() {
        ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            ivBack -> {
                onBackPressed()
            }
        }
    }

    override fun onNavigationItemClick(view: View, item: NavigationItem) {
        when (item.id) {
            NavigationItemType.LIST_EXPANDABLE_1 -> {
                startActivity(Intent(view.context, ExpandableListActivity::class.java))
            }
            NavigationItemType.LIST_DRAG_DROP_1 -> {
                startActivity(Intent(view.context, DragAndDropActivity::class.java))
            }
            NavigationItemType.LIST_SWIPE_TO_DISMISS_1 -> {
                startActivity(Intent(view.context, SwipeButtonActivity::class.java))
            }
            NavigationItemType.LIST_SWIPE_TO_DISMISS_2 -> {
                startActivity(Intent(view.context, SwipeIconActivity::class.java))
            }
        }
    }
}