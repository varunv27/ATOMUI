package com.decouikit.atom.components.wizard.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.profile.model.WizardProfileItem
import kotlinx.android.synthetic.main.fragment_wizard_profile.view.*

class WizardProfileFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View
    private var item: WizardProfileItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(WIZARD_PROFILE_ITEM_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_wizard_profile, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        viewLayout.tvItemTitle.text = item?.title
        viewLayout.tvItemSubtitle.text = item?.subtitle
        viewLayout.ivAvatarItem.setImageDrawable(item?.avatarDrawableRes?.let {
            ContextCompat.getDrawable(
                viewLayout.context,
                it
            )
        })
        initListeners()
    }

    private fun initListeners() {
        viewLayout.clParent.setOnClickListener(this)
        viewLayout.btnFollow.setOnClickListener(this)
        viewLayout.btnMessage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            viewLayout.clParent -> {
                Toast.makeText(viewLayout.context, item?.title, Toast.LENGTH_SHORT)
                    .show()
            }
            viewLayout.btnFollow -> {
                Toast.makeText(viewLayout.context, R.string.list_button_text_5, Toast.LENGTH_SHORT)
                    .show()
            }
            viewLayout.btnMessage -> {
                Toast.makeText(viewLayout.context, R.string.list_button_text_1, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {
        private const val WIZARD_PROFILE_ITEM_DATA = "WIZARD_PROFILE_ITEM_DATA"
        fun newInstance(item: WizardProfileItem): WizardProfileFragment {
            val fragment = WizardProfileFragment()
            val args = Bundle()
            args.putParcelable(WIZARD_PROFILE_ITEM_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}