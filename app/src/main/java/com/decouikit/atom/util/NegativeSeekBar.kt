package com.decouikit.atom.util

import android.content.Context
import android.util.AttributeSet
import android.widget.SeekBar

import androidx.appcompat.widget.AppCompatSeekBar

class NegativeSeekBar : AppCompatSeekBar {

    private var minimumValue = 0
    private var maximumValue = 0
    private var listener: OnSeekBarChangeListener? = null

    constructor(context: Context) : super(context) {
        setUpInternalListener()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setUpInternalListener()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        setUpInternalListener()
    }

    override fun setMin(min: Int) {
        this.minimumValue = min
        super.setMax(maximumValue - minimumValue)
    }

    override fun setMax(max: Int) {
        this.maximumValue = max
        super.setMax(maximumValue - minimumValue)
    }

    override fun setOnSeekBarChangeListener(listener: OnSeekBarChangeListener) {
        this.listener = listener
    }

    private fun setUpInternalListener() {
        super.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (listener != null) {
                    listener!!.onProgressChanged(seekBar, minimumValue + i, b)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                if (listener != null)
                    listener!!.onStartTrackingTouch(seekBar)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (listener != null)
                    listener!!.onStopTrackingTouch(seekBar)
            }
        })
    }
}