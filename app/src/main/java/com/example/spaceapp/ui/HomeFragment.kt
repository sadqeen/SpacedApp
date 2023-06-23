package com.example.spaceapp.ui

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceapp.R
import com.example.spaceapp.base.BaseFragment
import com.example.spaceapp.databinding.HomeFragmentBinding
import com.example.spaceapp.utils.CenterZoomLayoutManager
import com.example.spaceapp.utils.SpacesItemDecoration

class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    private lateinit var homeFragmentBinding: HomeFragmentBinding
    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeFragmentBinding = getViewDataBinding()
        var adapter=ItemAdapter(requireActivity())
        var layoutManager= CenterZoomLayoutManager(requireContext(), RecyclerView.HORIZONTAL,false)
        homeFragmentBinding.recycler.layoutManager=layoutManager

        val snapHelper: LinearSnapHelper = object : LinearSnapHelper() {
            override fun findTargetSnapPosition(
                layoutManager: RecyclerView.LayoutManager,
                velocityX: Int,
                velocityY: Int
            ): Int {
                val centerView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
                val position = layoutManager.getPosition(centerView)
                var targetPosition = -1
                if (layoutManager.canScrollHorizontally()) {
                    targetPosition = if (velocityX < 0) {
                        position - 1
                    } else {
                        position + 1
                    }
                }
                if (layoutManager.canScrollVertically()) {
                    targetPosition = if (velocityY < 0) {
                        position - 1
                    } else {
                        position + 1
                    }
                }
                val firstItem = 0
                val lastItem = layoutManager.itemCount - 1
                targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem))
                return targetPosition
            }
        }
        snapHelper.attachToRecyclerView(homeFragmentBinding.recycler)
        val space = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 12f,
            resources.displayMetrics
        ).toInt() // calculated

        homeFragmentBinding.recycler.addItemDecoration(SpacesItemDecoration(space))
        homeFragmentBinding.recycler.adapter=adapter

        homeFragmentBinding.recycler.postDelayed(Runnable {
            homeFragmentBinding.recycler.smoothScrollBy(100,0)
        },1000)

    }

}