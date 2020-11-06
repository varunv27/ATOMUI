package com.decouikit.atom.components.wizard.e_commerce.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.wizard.e_commerce.model.WizardECommerceItem
import com.decouikit.atom.extensions.setImageBgFromDrawable
import kotlinx.android.synthetic.main.fragment_wizard_e_commerce.view.*

class WizardECommerceFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View
    private var item: WizardECommerceItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getParcelable(WIZARD_E_COMMERCE_ITEM_DATA)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_wizard_e_commerce, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view
        viewLayout.tvItemTitle.text = item?.title
        viewLayout.tvItemSubtitle.text = item?.subtitle
        viewLayout.ivItemBg.ivItemBg.setImageDrawable(item?.backgroundPhotoDrawableRes?.let {
            ContextCompat.getDrawable(viewLayout.context,
                it
            )
        })
        initListeners()
    }

    private fun initListeners() {
        viewLayout.clParent.setOnClickListener(this)
        viewLayout.ivLike.setOnClickListener(this)
        viewLayout.btnReadMore.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            viewLayout.clParent -> {
                Toast.makeText(viewLayout.context, item?.title, Toast.LENGTH_SHORT).show()
            }
            viewLayout.ivLike -> {
                if (item?.isLiked!!) {
                    item?.isLiked = false
                    viewLayout.ivLike.setImageBgFromDrawable(R.drawable.ic_heart)
                } else {
                    item?.isLiked = true
                    viewLayout.ivLike.setImageBgFromDrawable(R.drawable.ic_heart_selected)
                }
            }
            viewLayout.btnReadMore -> {
                Toast.makeText(viewLayout.context, R.string.on_button_click, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val WIZARD_E_COMMERCE_ITEM_DATA = "WIZARD_E_COMMERCE_ITEM_DATA"
        fun newInstance(item: WizardECommerceItem): WizardECommerceFragment {
            val fragment = WizardECommerceFragment()
            val args = Bundle()
            args.putParcelable(WIZARD_E_COMMERCE_ITEM_DATA, item)
            fragment.arguments = args
            return fragment
        }
    }
}