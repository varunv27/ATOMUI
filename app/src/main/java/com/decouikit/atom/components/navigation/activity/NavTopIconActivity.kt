package com.decouikit.atom.components.navigation.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.decouikit.atom.R
import com.decouikit.atom.components.navigation.fragment.NavBlogFragment
import com.decouikit.atom.components.navigation.fragment.NavProductFragment
import com.decouikit.atom.components.navigation.fragment.NavProfileFragment
import com.decouikit.atom.components.navigation.model.NavBlogItem
import com.decouikit.atom.components.navigation.model.NavProductItem
import com.decouikit.atom.components.navigation.model.NavProfileItem
import com.decouikit.atom.components.navigation.repository.NavBlogRepository
import com.decouikit.atom.components.navigation.repository.NavProductRepository
import com.decouikit.atom.components.navigation.repository.NavProfileRepository
import com.decouikit.atom.extensions.replaceFragment
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.SharedPrefs
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_top_navigation_icon.*

class NavTopIconActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    View.OnClickListener {

    private lateinit var profileItems: ArrayList<NavProfileItem>
    private lateinit var productItems: ArrayList<NavProductItem>
    private lateinit var blogItems: ArrayList<NavBlogItem>
    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)

        setContentView(R.layout.activity_top_navigation_icon)

        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.parent)

        initValues()
        loadHomeFragment()
        initListeners()
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

    @SuppressLint("CheckResult")
    private fun initValues() {
        NavProfileRepository.getData(this).subscribeBy {
            profileItems = it as ArrayList<NavProfileItem>
        }
        NavProductRepository.getData(this).subscribeBy {
            productItems = it as ArrayList<NavProductItem>
        }
        NavBlogRepository.getData(this).subscribeBy {
            blogItems = it as ArrayList<NavBlogItem>
        }
    }

    private fun loadHomeFragment() {
        replaceFragment(NavProfileFragment.newInstance(profileItems), R.id.navigation_container)
    }

    private fun initListeners() {
        ivBack.setOnClickListener(this)
        navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onClick(v: View) {
        when(v) {
            ivBack -> {
                onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_profile -> {
                replaceFragment(NavProfileFragment.newInstance(profileItems), R.id.navigation_container)
                return true
            }
            R.id.nav_product -> {
                replaceFragment(NavProductFragment.newInstance(productItems), R.id.navigation_container)
                return true
            }
            R.id.nav_blog -> {
                replaceFragment(NavBlogFragment.newInstance(blogItems), R.id.navigation_container)
                return true
            }
        }
        return false
    }
}