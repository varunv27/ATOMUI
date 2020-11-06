package com.decouikit.atom.components.range.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import io.apptik.widget.MultiSlider
import kotlinx.android.synthetic.main.fragment_range.view.*

class RangeFragment : Fragment(), SeekBar.OnSeekBarChangeListener,
    MultiSlider.OnThumbValueChangeListener {

    private lateinit var viewLayout: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_range, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        initBasicRange()
        initIconRange()
        initStepRange()
        initMultiRange()
        initListeners()
    }

    private fun initBasicRange() {
        viewLayout.tvBasicResult.text = viewLayout.sbBasic.progress.toString()
    }

    private fun initIconRange() {
        viewLayout.sbIcon.min = viewLayout.sbIcon.max - 400
        viewLayout.sbIcon.progress = viewLayout.sbIcon.max - 200
        viewLayout.tvIconResult.text = "0"
    }

    private fun initStepRange() {
        viewLayout.tvStepResult.text = 1500.toString()
    }

    private fun initMultiRange() {
        viewLayout.sbTwoSliders.getThumb(0).value = 20
        viewLayout.sbTwoSliders.getThumb(1).value = 60
        viewLayout.tvTwoSlidersResult.text = getString(
            R.string.multi_range_value,
            viewLayout.sbTwoSliders?.getThumb(0)?.value,
            viewLayout.sbTwoSliders?.getThumb(1)?.value
        )
    }

    private fun initListeners() {
        viewLayout.sbBasic.setOnSeekBarChangeListener(this)
        viewLayout.sbIcon.setOnSeekBarChangeListener(this)
        viewLayout.sbStep.setOnSeekBarChangeListener(this)
        viewLayout.sbTwoSliders.setOnThumbValueChangeListener(this)
    }

    override fun onValueChanged(
        multiSlider: MultiSlider?,
        thumb: MultiSlider.Thumb?,
        thumbIndex: Int,
        value: Int
    ) {
        viewLayout.tvTwoSlidersResult.text = getString(
            R.string.multi_range_value,
            multiSlider?.getThumb(0)?.value,
            multiSlider?.getThumb(1)?.value
        )
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        when (seekBar) {
            viewLayout.sbBasic -> {
                viewLayout.tvBasicResult.text = progress.toString()
            }
            viewLayout.sbIcon -> {
                viewLayout.tvIconResult.text = progress.toString()
            }
            viewLayout.sbStep -> {
                setStepSeekBarProgressValue(progress)
            }
            viewLayout.sbStep -> {
                setStepSeekBarProgressValue(progress)
            }
        }
    }

    private fun setStepSeekBarProgressValue(progress: Int) {
        when (progress) {
            0 -> {
                viewLayout.tvStepResult.text = 1000.toString()
            }
            1 -> {
                viewLayout.tvStepResult.text = 1100.toString()
            }
            2 -> {
                viewLayout.tvStepResult.text = 1200.toString()
            }
            3 -> {
                viewLayout.tvStepResult.text = 1300.toString()
            }
            4 -> {
                viewLayout.tvStepResult.text = 1400.toString()
            }
            5 -> {
                viewLayout.tvStepResult.text = 1500.toString()
            }
            6 -> {
                viewLayout.tvStepResult.text = 1600.toString()
            }
            7 -> {
                viewLayout.tvStepResult.text = 1700.toString()
            }
            8 -> {
                viewLayout.tvStepResult.text = 1800.toString()
            }
            9 -> {
                viewLayout.tvStepResult.text = 1900.toString()
            }
            10 -> {
                viewLayout.tvStepResult.text = 2000.toString()
            }
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

    companion object {
        fun newInstance(): RangeFragment {
            return RangeFragment()
        }
    }
}