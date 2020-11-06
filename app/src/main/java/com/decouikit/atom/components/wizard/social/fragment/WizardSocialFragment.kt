package com.decouikit.atom.components.wizard.social.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.social.model.WizardSocialItem
import com.decouikit.atom.extensions.setButtonText
import kotlinx.android.synthetic.main.fragment_wizard_social.view.*

class WizardSocialFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View
    private var item: WizardSocialItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        item = arguments?.getParcelable(WIZARD_SOCIAL_ITEM_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_wizard_social, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        viewLayout.tvItemTitle.text = item?.title
        viewLayout.tvItemSubtitle.text = item?.subtitle
        viewLayout.textName.text = item?.name
        viewLayout.textArticles.text = item?.articles
        viewLayout.ivItemBg.setImageDrawable(item?.backgroundPhotoDrawableRes?.let {
            ContextCompat.getDrawable(viewLayout.context,
                it
            )
        })
        viewLayout.imageAvatar.setImageDrawable(item?.avatarDrawableRes?.let {
            ContextCompat.getDrawable(viewLayout.context,
                it
            )
        })
        initListeners()
    }

    private fun initListeners() {
        viewLayout.clParent.setOnClickListener(this)
        viewLayout.btnFollowing.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            viewLayout.clParent -> {
                Toast.makeText(viewLayout.context, item?.subtitle, Toast.LENGTH_SHORT)
                    .show()
            }
            viewLayout.btnFollowing -> {
                item?.isFollowing = !item?.isFollowing!!
                viewLayout.btnFollowing.setButtonText(item?.isFollowing!!)
            }
        }
    }

    companion object {
        private const val WIZARD_SOCIAL_ITEM_DATA = "WIZARD_SOCIAL_ITEM_DATA"
        fun newInstance(item: WizardSocialItem): WizardSocialFragment {
            val fragment = WizardSocialFragment()
            val args = Bundle()
            args.putParcelable(WIZARD_SOCIAL_ITEM_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}