package com.decouikit.atom.components.navigation.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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
import com.decouikit.atom.extensions.setSelectedTabTextColor
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.SharedPrefs
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_bottom_navigation_text.*

class NavBottomTextActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var profileItems: ArrayList<NavProfileItem>
    private lateinit var productItems: ArrayList<NavProductItem>
    private lateinit var blogItems: ArrayList<NavBlogItem>
    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }
    private val value = TypedValue()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)

        setContentView(R.layout.activity_bottom_navigation_text)

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
        setSelectedTabTextColor(this, value, nav_profile, nav_product, nav_blog)
        replaceFragment(NavProfileFragment.newInstance(profileItems), R.id.navigation_container)
    }

    private fun initListeners() {
        ivBack.setOnClickListener(this)
        nav_profile.setOnClickListener(this)
        nav_product.setOnClickListener(this)
        nav_blog.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v) {
            ivBack -> {
                onBackPressed()
            }
            nav_profile -> {
                setSelectedTabTextColor(this, value, nav_profile, nav_product, nav_blog)
                replaceFragment(NavProfileFragment.newInstance(profileItems), R.id.navigation_container)
            }
            nav_product -> {
                setSelectedTabTextColor(this, value, nav_product, nav_profile, nav_blog)
                replaceFragment(NavProductFragment.newInstance(productItems), R.id.navigation_container)
            }
            nav_blog -> {
                setSelectedTabTextColor(this, value, nav_blog, nav_profile, nav_product)
                replaceFragment(NavBlogFragment.newInstance(blogItems), R.id.navigation_container)
            }
        }
    }
}