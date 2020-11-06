package com.decouikit.atom.components.small_components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.decouikit.atom.R

class SmallComponentsFragment : Fragment() {

    private lateinit var viewLayout: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_small_components, container, false))
        return this.viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
    }

    companion object {
        fun newInstance(): SmallComponentsFragment {
            return SmallComponentsFragment()
        }
    }
}