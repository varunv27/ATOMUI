package com.decouikit.atom.components.select.single.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.select.single.adapter.RadioButtonSimpleRightAdapter
import com.decouikit.atom.components.select.single.interfaces.OnSelectDialogListener
import com.decouikit.atom.components.select.single.model.RadioButtonItem
import kotlinx.android.synthetic.main.dialog_select.view.*

object SelectDialog : OnSelectDialogListener {

    private var selectedCity: RadioButtonItem? = null
    private var adapter: RadioButtonSimpleRightAdapter? = null

    @SuppressLint("InflateParams")
    fun show(activity: Activity, adapterList: List<RadioButtonItem>, listener: OnSelectDialogListener) {

        var dialog: AlertDialog? = null
        val dialogBuilder = AlertDialog.Builder(activity)
        val dialogView = activity.layoutInflater.inflate(R.layout.dialog_select, null)
        adapter = RadioButtonSimpleRightAdapter(this)
        dialogView.rvList.layoutManager = LinearLayoutManager(activity)
        dialogView.rvList.adapter = adapter
        dialogView.tvOk.setOnClickListener {
            selectedCity?.let { it1 -> listener.onSelectDialogItem(it1) }
            dialog?.cancel()
        }
        dialogView.tvCancel.setOnClickListener {
            dialog?.cancel()
        }

        dialogBuilder.setView(dialogView)
        dialog = dialogBuilder.show()
        Handler().postDelayed({
            adapter?.setItems(adapterList)
        }, 30)
    }

    override fun onSelectDialogItem(item: RadioButtonItem) {
        selectedCity = item
    }
}