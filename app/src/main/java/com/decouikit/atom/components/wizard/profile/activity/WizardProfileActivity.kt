package com.decouikit.atom.components.wizard.profile.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.profile.adapter.StyledCardAdapter
import com.decouikit.atom.components.wizard.profile.adapter.WizardPagerAdapter
import com.decouikit.atom.components.wizard.profile.fragment.WizardProfileFragment
import com.decouikit.atom.components.wizard.profile.interfaces.OnItemClickListener
import com.decouikit.atom.components.wizard.profile.model.StyledCardItem
import com.decouikit.atom.components.wizard.profile.repository.StyledCardRepository
import com.decouikit.atom.components.wizard.profile.repository.WizardProfileRepository
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.SharedPrefs
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_wizard_profile.*

class WizardProfileActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, View.OnClickListener,
    OnItemClickListener {

    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }
    private lateinit var adapter: WizardPagerAdapter
    private lateinit var listAdapter: StyledCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(R.layout.activity_wizard_profile)

        ActivityUtil.setLayoutDirection(this, getLayoutDirection(), R.id.parent)
        initLayout()
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
    private fun initLayout() {
        adapter = WizardPagerAdapter(
            supportFragmentManager
        )
        WizardProfileRepository.getData(this).subscribeBy {
            adapter.addFragment(WizardProfileFragment.newInstance(it))
        }
        StyledCardRepository.getData(this).subscribeBy {
            listAdapter = StyledCardAdapter(it as ArrayList<StyledCardItem>)
        }
        listAdapter.setOnItemClickListener(this)

        viewPager.clipToPadding = false
        viewPager.setPadding(
            resources.getDimension(R.dimen.padding_extra_large).toInt(),
            0,
            resources.getDimension(R.dimen.padding_extra_large).toInt(),
            0
        )
        viewPager.pageMargin = resources.getDimension(R.dimen.margin_extra_large).toInt()
        viewPager.adapter = adapter
        tabDots.setupWithViewPager(viewPager)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = listAdapter
    }

    private fun initListeners() {
        ivBack.setOnClickListener(this)
        viewPager.addOnPageChangeListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            ivBack -> {
                onBackPressed()
            }
        }
    }

    override fun onItemClick(item: StyledCardItem) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
    }

    override fun onCommentsClick() {
        Toast.makeText(this, R.string.on_comment_click, Toast.LENGTH_SHORT).show()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }
}