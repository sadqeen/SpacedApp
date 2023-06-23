package com.example.spaceapp.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.example.spaceapp.R
import com.example.spaceapp.databinding.SucessfullFragmentBinding
import com.example.spaceapp.utils.SingleLiveEvent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SucessFullFragment : BottomSheetDialogFragment() {
    private lateinit var sucessfulFragmentBinding: SucessfullFragmentBinding
    private var behaviour: BottomSheetBehavior<View>? = null
    companion object{
        val dismissEvent= SingleLiveEvent<Boolean>()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sucessfulFragmentBinding = SucessfullFragmentBinding.inflate(inflater, container, false)
        sucessfulFragmentBinding.tvDone.setOnClickListener {
            dismiss()
            dismissEvent.postValue(true)
        }
        return sucessfulFragmentBinding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = super.onCreateDialog(savedInstanceState)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setOnShowListener { dialogInterface ->
            val bottomSheetDialog: BottomSheetDialog = dialogInterface as BottomSheetDialog
            val parentLayout =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { it ->
                behaviour = BottomSheetBehavior.from(it)
                behaviour!!.isHideable = false
                behaviour!!.isDraggable = false
                setupFullHeight(it)
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


    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }


    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }
}