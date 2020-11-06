package com.decouikit.atom.components.rtl_color_change.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.util.ActivityUtil
import com.decouikit.atom.util.SharedPrefs
import kotlinx.android.synthetic.main.fragment_rtl_color_change.view.*

class RtlColorChangeFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View

    private val prefs: SharedPrefs by lazy {
        SharedPrefs(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_rtl_color_change, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        viewLayout.rtlCheckbox.isChecked = prefs.isRtlEnabled

        initListeners()
    }

    private fun initListeners() {
        viewLayout.rtlCheckbox.setOnClickListener(this)
        viewLayout.btnMainTheme.setOnClickListener(this)
        viewLayout.btnPurpleTheme.setOnClickListener(this)
        viewLayout.btnOrangeTheme.setOnClickListener(this)
        viewLayout.btnTealTheme.setOnClickListener(this)
        viewLayout.btnRedTheme.setOnClickListener(this)
        viewLayout.btnGreenTheme.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v) {
            viewLayout.rtlCheckbox -> {
                setRtlMode(v)
            }
            viewLayout.btnMainTheme -> {
                setTheme(R.style.AppTheme)
            }
            viewLayout.btnPurpleTheme -> {
                setTheme(R.style.AppThemePurple)
            }
            viewLayout.btnOrangeTheme -> {
                setTheme(R.style.AppThemeOrange)
            }
            viewLayout.btnTealTheme -> {
                setTheme(R.style.AppThemeTeal)
            }
            viewLayout.btnRedTheme -> {
                setTheme(R.style.AppThemeRed)
            }
            viewLayout.btnGreenTheme -> {
                setTheme(R.style.AppThemeGreen)
            }
        }
    }

    private fun setRtlMode(v: View) {
        val isChecked: Boolean = (v as CheckBox).isChecked
        prefs.isRtlEnabled = isChecked
        if (isChecked) {
            activity?.let {
                ActivityUtil.setLayoutDirection(
                    it,
                    ViewCompat.LAYOUT_DIRECTION_RTL,
                    R.id.parent
                )
            }
        } else {
            activity?.let {
                ActivityUtil.setLayoutDirection(
                    it,
                    ViewCompat.LAYOUT_DIRECTION_LOCALE,
                    R.id.parent
                )
            }
        }
        ActivityUtil.reload(activity)
    }

    private fun setTheme(theme: Int) {
        prefs.colorTheme = theme
        ActivityUtil.reload(activity)
    }

    companion object {
        fun newInstance(): RtlColorChangeFragment {
            return RtlColorChangeFragment()
        }
    }
}