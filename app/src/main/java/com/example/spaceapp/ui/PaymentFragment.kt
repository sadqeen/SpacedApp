package com.example.spaceapp.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.spaceapp.R
import com.example.spaceapp.databinding.PaymentLayoutBinding
import com.example.spaceapp.utils.SingleLiveEvent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PaymentFragment : BottomSheetDialogFragment() {
    private lateinit var paymentLayoutBinding: PaymentLayoutBinding
    private var behaviour: BottomSheetBehavior<View>? = null

    companion object {
        val dismissEvent = SingleLiveEvent<Boolean>()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        paymentLayoutBinding = PaymentLayoutBinding.inflate(inflater, container, false)
        var sucessFullFragment = SucessFullFragment()
        SucessFullFragment.dismissEvent.observe(viewLifecycleOwner, Observer {
            if (it) {
                dismiss()
                dismissEvent.postValue(true)

            }
        })
        paymentLayoutBinding.tvScan.setOnClickListener {
            sucessFullFragment.show(childFragmentManager, SucessFullFragment::class.java.simpleName)

        }
        return paymentLayoutBinding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog: BottomSheetDialog = dialogInterface as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)

            parentLayout?.let { it ->
                behaviour = BottomSheetBehavior.from(it)
                behaviour!!.isHideable = true
                behaviour!!.isDraggable = true
                behaviour?.state = BottomSheetBehavior.STATE_EXPANDED
                behaviour?.addBottomSheetCallback(object :
                    BottomSheetBehavior.BottomSheetCallback() {
                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        when (newState) {
                            BottomSheetBehavior.STATE_HIDDEN -> {

                            }
                            BottomSheetBehavior.STATE_COLLAPSED -> {

                            }
                            else -> {

                            }
                        }
                    }

                    override fun onSlide(bottomSheet: View, slideOffset: Float) {

                    }
                })


            }
        }

        return dialog
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }
}