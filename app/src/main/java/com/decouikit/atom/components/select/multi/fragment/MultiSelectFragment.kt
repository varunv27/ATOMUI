package com.decouikit.atom.components.select.multi.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.decouikit.atom.R
import com.decouikit.atom.components.select.multi.dialog.SelectDialog
import com.decouikit.atom.components.select.multi.interfaces.OnSelectDialogListener
import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import com.decouikit.atom.components.select.multi.repository.CountryRepository
import com.decouikit.atom.components.select.multi.repository.MonthRepository
import com.decouikit.atom.components.select.multi.repository.YearRepository
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_multi_select.view.*

class MultiSelectFragment : Fragment(), View.OnClickListener {

    private lateinit var viewLayout: View

    private var countryList = arrayListOf<CheckBoxItem>()
    private var monthList = arrayListOf<CheckBoxItem>()
    private var yearList = arrayListOf<CheckBoxItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_multi_select, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        initCountryDialog()
        initMonthDialog()
        initYearDialog()

        initListeners()
    }

    @SuppressLint("CheckResult")
    private fun initCountryDialog() {
        CountryRepository.getData(viewLayout.context).subscribeBy {
            countryList = it as ArrayList<CheckBoxItem>
            countryListener.onSelectDialogItem(it)
        }
    }

    @SuppressLint("CheckResult")
    private fun initMonthDialog() {
        MonthRepository.getData().subscribeBy {
            monthList = it as ArrayList<CheckBoxItem>
            monthListener.onSelectDialogItem(it)
        }
    }

    @SuppressLint("CheckResult")
    private fun initYearDialog() {
        YearRepository.getData().subscribeBy {
            yearList = it as ArrayList<CheckBoxItem>
            yearListener.onSelectDialogItem(it)
        }
    }

    private fun initListeners() {
        viewLayout.countryParent.setOnClickListener(this)
        viewLayout.countrySpinner.setOnClickListener(this)
        viewLayout.monthSpinner.setOnClickListener(this)
        viewLayout.tvMonthResult.setOnClickListener(this)
        viewLayout.yearSpinner.setOnClickListener(this)
        viewLayout.tvYearResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            viewLayout.countryParent,
            viewLayout.countrySpinner -> {
                activity?.let { SelectDialog.show(it, getString(R.string.country), countryList, countryListener) }
            }
            viewLayout.monthSpinner,
            viewLayout.tvMonthResult -> {
                activity?.let { SelectDialog.show(it, getString(R.string.month), monthList, monthListener) }
            }
            viewLayout.tvYearResult,
            viewLayout.yearSpinner -> {
                activity?.let { SelectDialog.show(it, getString(R.string.year), yearList, yearListener) }
            }
        }
    }

    private val countryListener = object: OnSelectDialogListener {
        override fun onSelectDialogItem(items: List<CheckBoxItem>) {
            addSelectedItems(items, viewLayout.tvCountryResult)
        }
    }

    private val monthListener = object: OnSelectDialogListener {
        override fun onSelectDialogItem(items: List<CheckBoxItem>) {
            addSelectedItems(items, viewLayout.tvMonthResult)
        }
    }

    private val yearListener = object: OnSelectDialogListener {
        override fun onSelectDialogItem(items: List<CheckBoxItem>) {
            addSelectedItems(items, viewLayout.tvYearResult)
        }
    }

    private fun addSelectedItems(items: List<CheckBoxItem>, textView: TextView) {
        var selectedDialogText = ""
        items.filter { it.isSelected }.forEach {
            selectedDialogText += it.title + ", "
        }
        if (selectedDialogText.isNotEmpty()) {
            selectedDialogText = selectedDialogText.take(selectedDialogText.length - 2)
        }
        textView.text = selectedDialogText
    }

    companion object {
        fun newInstance() : MultiSelectFragment {
            return MultiSelectFragment()
        }
    }
}