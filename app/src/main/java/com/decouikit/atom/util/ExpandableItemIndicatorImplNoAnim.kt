package com.decouikit.atom.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.decouikit.atom.R

internal class ExpandableItemIndicatorImplNoAnim : ExpandableItemIndicator.Impl() {
    private var mImageView: AppCompatImageView? = null

    override fun onInit(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        expandableItemIndicator: ExpandableItemIndicator
    ) {
        val v = LayoutInflater.from(context)
            .inflate(R.layout.widget_expandable_item_indicator, expandableItemIndicator, true)
        mImageView = v.findViewById(R.id.image_view)
    }

    override fun setExpandedState(isExpanded: Boolean, animate: Boolean) {
        @DrawableRes val resId =
            if (isExpanded) R.drawable.ic_shape_up else R.drawable.ic_shape
        mImageView!!.setImageResource(resId)
    }
}

