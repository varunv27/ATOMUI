package com.decouikit.atom.components.select.single.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.select.single.adapter.AddressAdapter
import com.decouikit.atom.components.select.single.dialog.SelectDialog
import com.decouikit.atom.components.select.single.interfaces.OnAddressItemClickListener
import com.decouikit.atom.components.select.single.interfaces.OnSelectDialogListener
import com.decouikit.atom.components.select.single.model.RadioButtonItem
import com.decouikit.atom.components.select.single.repository.*
import com.decouikit.atom.extensions.createSingleChoiceDropDown
import com.google.android.material.bottomsheet.BottomSheetDialog
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.bottom_sheet_address.*
import kotlinx.android.synthetic.main.fragment_single_select.view.*


class SingleSelectFragment : Fragment(), View.OnClickListener, OnAddressItemClickListener,
    OnSelectDialogListener {
    private lateinit var viewLayout: View

    private lateinit var addressAdapter: AddressAdapter
    private lateinit var bottomSheetDialogAddress: BottomSheetDialog

    private var cityList = arrayListOf<RadioButtonItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loadView(inflater.inflate(R.layout.fragment_single_select, container, false))
        return viewLayout
    }

    private fun loadView(view: View) {
        viewLayout = view

        initCityDialog()
        initCountrySpinner()
        initAddressBottomSheet()
        initDateSpinner()

        initListeners()
    }

    @SuppressLint("CheckResult")
    private fun initCityDialog() {
        RadioButtonSimpleRepository.getData().subscribeBy {
            cityList = it as ArrayList<RadioButtonItem>
            onSelectDialogItem(cityList.first { city -> city.isSelected })
        }
    }

    @SuppressLint("CheckResult", "InflateParams")
    private fun initAddressBottomSheet() {
        AddressRepository.getData().subscribeBy {
            addressAdapter = AddressAdapter(it, this)
        }
        bottomSheetDialogAddress = BottomSheetDialog(viewLayout.context)
        bottomSheetDialogAddress.setContentView(
            layoutInflater.inflate(
                R.layout.bottom_sheet_address,
                null
            )
        )
        bottomSheetDialogAddress.rvList.layoutManager = LinearLayoutManager(context)
        bottomSheetDialogAddress.rvList.adapter = addressAdapter
    }

    @SuppressLint("CheckResult")
    private fun initCountrySpinner() {
        CityRepository.getData().subscribeBy {
            viewLayout.countrySpinner.createSingleChoiceDropDown(
                viewLayout.context,
                it,
                R.layout.spinner_item,
                R.layout.spinner_dropdown_single_item
            )
        }
    }

    @SuppressLint("CheckResult")
    private fun initDateSpinner() {
        MonthRepository.getData().subscribeBy {
            viewLayout.monthSpinner.createSingleChoiceDropDown(
                viewLayout.context,
                it,
                R.layout.spinner_item,
                R.layout.spinner_dropdown_single_item
            )
        }
        YearRepository.getData().subscribeBy {
            viewLayout.yearSpinner.createSingleChoiceDropDown(
                viewLayout.context,
                it,
                R.layout.spinner_item,
                R.layout.spinner_dropdown_single_item
            )
        }
    }

    private fun initListeners() {
        viewLayout.addressParent.setOnClickListener(this)
        viewLayout.addressSpinner.setOnClickListener(this)
        bottomSheetDialogAddress.tvCancel.setOnClickListener(this)
        viewLayout.cityParent.setOnClickListener(this)
        viewLayout.citySpinner.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            viewLayout.addressParent,
            viewLayout.addressSpinner -> {
                bottomSheetDialogAddress.show()
            }
            bottomSheetDialogAddress.tvCancel -> {
                bottomSheetDialogAddress.dismiss()
            }
            viewLayout.cityParent,
            viewLayout.citySpinner -> {
                activity?.let { SelectDialog.show(it, cityList, this) }
            }
        }
    }

    override fun onAddressItemClick(item: String) {
        activity?.runOnUiThread {
            viewLayout.tvAddressResult.text = item
            bottomSheetDialogAddress.dismiss()
        }
    }

    override fun onSelectDialogItem(item: RadioButtonItem) {
        activity?.runOnUiThread {
            viewLayout.tvCityResult.text = item.title
        }
    }

    companion object {
        fun newInstance(): SingleSelectFragment {
            return SingleSelectFragment()
        }
    }
}