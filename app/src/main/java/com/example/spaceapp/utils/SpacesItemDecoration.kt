package com.example.spaceapp.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration (var space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view!!)
        val isLast = position == state.itemCount - 1
        if (isLast) {
            outRect.right = space
            // outRect.top = 0 //don't forget about recycling...
        }
        if (position == 0) {
            outRect.left = space
            // don't recycle bottom if first item is also last
            // should keep bottom padding set above
            //if (!isLast) outRect.bottom = 0
        }
    }
}