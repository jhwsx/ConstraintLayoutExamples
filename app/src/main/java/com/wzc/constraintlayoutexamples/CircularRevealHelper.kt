package com.wzc.constraintlayoutexamples

import android.content.Context
import android.util.AttributeSet
import android.view.ViewAnimationUtils
import androidx.constraintlayout.widget.ConstraintHelper
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.hypot

/**
 * 自定义 Helper
 * @author wangzhichao
 * @since 2022/8/18
 */
class CircularRevealHelper(context: Context, attrs: AttributeSet?) :
    ConstraintHelper(context, attrs) {
    // 在 onLayout 之前回调
    override fun updatePreLayout(container: ConstraintLayout) {
        super.updatePreLayout(container)
    }

    // 在 onLayout 之后回调
    override fun updatePostLayout(container: ConstraintLayout) {
        super.updatePostLayout(container)
        referencedIds.forEach {
            val view = container.getViewById(it)
            // hypot:  计算直角三角形的斜边长。
            val radius = hypot(view.width.toDouble(), view.height.toDouble()).toInt()
            // centerX，centerY 表示圆形扩散的中心点
            // startRadius 表示开始半径，endRadius 表示结束半径。
            ViewAnimationUtils.createCircularReveal(view, 0, 0, 0f, radius.toFloat())
                .setDuration(2000L)
                .start()
        }
    }
}