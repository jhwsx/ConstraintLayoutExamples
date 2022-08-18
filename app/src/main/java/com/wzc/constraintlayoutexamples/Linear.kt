package com.wzc.constraintlayoutexamples

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.VirtualLayout

/**
 * 线性约束
 * @author wangzhichao
 * @since 2022/8/19
 */
class Linear(context: Context, attrs: AttributeSet?) : VirtualLayout(context, attrs) {
    private val constraintSet: ConstraintSet by lazy {
        ConstraintSet().apply { isForceId = false }
    }
    override fun updatePreLayout(container: ConstraintLayout) {
        super.updatePreLayout(container)
        constraintSet.clone(container)
        val viewIds = referencedIds
        for (i in 1 until mCount) {
            val currentViewId = viewIds[i]
            val lastViewId = viewIds[i - 1]
            constraintSet.connect(currentViewId, ConstraintSet.START, lastViewId, ConstraintSet.START)
            constraintSet.connect(currentViewId, ConstraintSet.TOP, lastViewId, ConstraintSet.BOTTOM)
            constraintSet.applyTo(container)
        }
    }
}