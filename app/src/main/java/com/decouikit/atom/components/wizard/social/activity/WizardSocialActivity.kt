package com.decouikit.atom.components.wizard.social.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.social.adapter.StyledTwoCardAdapter
import com.decouikit.atom.components.wizard.social.adapter.WizardPagerAdapter
import com.decouikit.atom.components.wizard.social.fragment.WizardSocialFragment
import com.decouikit.atom.components.wizard.social.interfaces.OnItemClickListener
import com.decouikit.atom.components.wizard.social.model.StyledTwoCardItem
import com.decouikit.atom.components.wizard.social.repository.StyledTwoCardRepository
import com.decouikit.atom.components.wizard.social.repository.WizardSocialRepository
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.SharedPrefs
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_wizard_social.*

class WizardSocialActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, View.OnClickListener,
    OnItemClickListener {

    private val prefs: SharedPrefs by lazy { SharedPrefs(this) }
    private lateinit var adapter: WizardPagerAdapter
    private lateinit var listAdapter: StyledTwoCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(prefs.colorTheme)
        setContentView(R.layout.activity_wizard_social)

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
        WizardSocialRepository.getData(this).subscribeBy {
            adapter.addFragment(WizardSocialFragment.newInstance(it))
        }
        StyledTwoCardRepository.getData(this).subscribeBy {
            listAdapter = StyledTwoCardAdapter(it as ArrayList<StyledTwoCardItem>)
        }
        listAdapter.setItemClickListener(this)

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

    override fun onItemClick(item: StyledTwoCardItem) {
        Toast.makeText(this, item.subtitle , Toast.LENGTH_SHORT).show()
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }
}