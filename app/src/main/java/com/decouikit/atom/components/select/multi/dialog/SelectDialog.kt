package com.decouikit.atom.components.select.multi.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.decouikit.atom.R
import com.decouikit.atom.components.select.multi.adapter.CheckboxSimpleRightAdapter
import com.decouikit.atom.components.select.multi.interfaces.OnSelectDialogListener
import com.decouikit.atom.components.select.multi.model.CheckBoxItem
import kotlinx.android.synthetic.main.dialog_select.view.*

object SelectDialog : OnSelectDialogListener{

    private var selectedItems: ArrayList<CheckBoxItem> = arrayListOf()
    private var adapter: CheckboxSimpleRightAdapter? = null

    @SuppressLint("InflateParams")
    fun show(
        activity: Activity,
        dialogTitle: String,
        adapterList: List<CheckBoxItem>,
        listener: OnSelectDialogListener
    ) {
        var dialog: AlertDialog? = null
        val dialogBuilder = AlertDialog.Builder(activity)
        val dialogView = activity.layoutInflater.inflate(R.layout.dialog_select, null)
        dialogView.tvDialogTitle.text = dialogTitle
        adapter = CheckboxSimpleRightAdapter(this)
        dialogView.rvList.layoutManager = LinearLayoutManager(activity)
        dialogView.rvList.adapter = adapter
        dialogView.tvOk.setOnClickListener {
            listener.onSelectDialogItem(selectedItems)
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

    override fun onSelectDialogItem(items: List<CheckBoxItem>) {
        selectedItems = items as ArrayList<CheckBoxItem>
    }
}