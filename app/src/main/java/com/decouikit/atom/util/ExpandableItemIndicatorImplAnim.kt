package com.decouikit.atom.util


import android.content.Context
import android.graphics.drawable.Animatable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.decouikit.atom.R

internal class ExpandableItemIndicatorImplAnim : ExpandableItemIndicator.Impl() {
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
        if (animate) {
            @DrawableRes val resId =
                if (isExpanded) R.drawable.ic_expand_more_to_expand_less else R.drawable.ic_expand_less_to_expand_more
            mImageView!!.setImageResource(resId)
            (mImageView!!.drawable as Animatable).start()
        } else {
            @DrawableRes val resId =
                if (isExpanded) R.drawable.ic_shape_up else R.drawable.ic_shape
            mImageView!!.setImageResource(resId)
        }
    }
}

