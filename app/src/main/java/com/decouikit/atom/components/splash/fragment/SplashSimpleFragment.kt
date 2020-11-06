package com.decouikit.atom.components.splash.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.view.animation.AnimationUtils
import com.decouikit.atom.R
import kotlinx.android.synthetic.main.fragment_splash_simple.view.*


class SplashSimpleFragment : Fragment() {

    private lateinit var viewLayout: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_splash_simple, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        val anim = AnimationUtils.loadAnimation(viewLayout.context, R.anim.splash_simple_anim)
        viewLayout.ivSplashLogo.startAnimation(anim)
        viewLayout.tvSplashTitle.startAnimation(anim)
    }

    companion object {
        fun newInstance(): SplashSimpleFragment {
            return SplashSimpleFragment()
        }
    }
}