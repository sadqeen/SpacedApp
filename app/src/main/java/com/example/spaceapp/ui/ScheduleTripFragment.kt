package com.example.spaceapp.ui

import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.lifecycle.Observer
import com.example.spaceapp.R
import com.example.spaceapp.databinding.ScheduleTripLayoutBinding
import com.example.spaceapp.utils.SingleLiveEvent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ScheduleTripFragment : BottomSheetDialogFragment() {

    private lateinit var scheduleTripLayoutBinding: ScheduleTripLayoutBinding
    private var behaviour: BottomSheetBehavior<View>? = null

    companion object {
        val dismissEvent = SingleLiveEvent<Boolean>()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        scheduleTripLayoutBinding =
            ScheduleTripLayoutBinding.inflate(inflater, container, false)
        ScheduleSeatsFragment.dismissEvent.observe(viewLifecycleOwner, Observer {
            if (it) {
                dismiss()
                dismissEvent.postValue(true)
            }
        })
        scheduleTripLayoutBinding.chipsgroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val scheduleSeatsFragment = ScheduleSeatsFragment()
            scheduleSeatsFragment.show(childFragmentManager, ScheduleTripFragment::class.java.simpleName)
        }

        scheduleTripLayoutBinding.layoutSeats.setOnClickListener {
            val scheduleSeatsFragment = ScheduleSeatsFragment()
            scheduleSeatsFragment.show(childFragmentManager, ScheduleTripFragment::class.java.simpleName)
        }
        return scheduleTripLayoutBinding.root
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
                behaviour!!.isHideable = true
                behaviour!!.isDraggable = true
                // setupFullHeight(it)
                //  parentLayout.setBackgroundResource(R.drawable.bottom_sheet_bg)
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
        val displayMetrics = DisplayMetrics()
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }

    fun getActionBarHeight(): Int {
        var actionBarHeight = 0
        val tv = TypedValue()
        actionBarHeight = TypedValue.complexToDimensionPixelSize(
            tv.data, resources.displayMetrics
        )

        return actionBarHeight
    }
}