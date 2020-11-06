package com.decouikit.atom.components.wizard.walkthrough.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.viewpager.widget.ViewPager
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.walkthrough.adapter.WizardPagerAdapter
import com.decouikit.atom.components.wizard.walkthrough.fragment.WizardFragment
import com.decouikit.atom.components.wizard.walkthrough.repository.WizardRepository
import com.decouikit.atom.extensions.openWebUrl
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.AtomConstants
import com.decouikit.atom.util.SharedPrefs
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_wizard_base.btnPurchase
import kotlinx.android.synthetic.main.activity_wizard_base.tabDots
import kotlinx.android.synthetic.main.activity_wizard_base.tvNext
import kotlinx.android.synthetic.main.activity_wizard_base.tvPrev
import kotlinx.android.synthetic.main.activity_wizard_base.viewPager
import kotlinx.android.synthetic.main.activity_wizard_walkthrough.*

class WizardWalkThroughActivity : AppCompatActivity(), ViewPager.OnPageChangeListener,
    View.OnClickListener {

    private lateinit var adapter: WizardPagerAdapter

    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(R.layout.activity_wizard_walkthrough)

        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.parent)
        initLayout()
        initListeners()
    }

    private fun getLayoutDirection(): Int {
        return if (prefs.isRtlEnabled) {
            ivBack.rotation = 180f
            ViewCompat.LAYOUT_DIRECTION_RTL
        } else {
            ViewCompat.LAYOUT_DIRECTION_LOCALE
        }
    }

    @SuppressLint("CheckResult")
    private fun initLayout() {
        tvPrev.visibility = View.INVISIBLE
        adapter = WizardPagerAdapter(
            supportFragmentManager
        )
        WizardRepository.getData(this).subscribeBy {
            adapter.addFragment(WizardFragment.newInstance(it))
        }
        viewPager.adapter = adapter
        tabDots.setupWithViewPager(viewPager)
    }

    private fun initListeners() {
        ivBack.setOnClickListener(this)
        viewPager.addOnPageChangeListener(this)
        tvPrev.setOnClickListener(this)
        tvNext.setOnClickListener(this)
        btnPurchase.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            ivBack -> {
                onBackPressed()
            }
            tvPrev -> {
                viewPager.currentItem = tabDots.selectedTabPosition - 1
            }
            tvNext -> {
                if (tabDots.selectedTabPosition == (adapter.count - 1)) {
                    finish()
                } else {
                    viewPager.currentItem = tabDots.selectedTabPosition + 1
                }
            }
            btnPurchase -> {
                v.openWebUrl(AtomConstants.DEV_PUSH_URL)
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        when (position) {
            0 -> {
                tvPrev.visibility = View.INVISIBLE
            }
            adapter.count - 1 -> {
                tvNext.text = getString(R.string.wizard_finish)
                tvPrev.visibility = View.VISIBLE
            }
            else -> {
                tvNext.text = getString(R.string.wizard_next)
                tvPrev.visibility = View.VISIBLE
            }
        }
    }
}