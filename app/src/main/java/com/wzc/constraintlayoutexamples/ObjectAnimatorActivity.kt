package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import androidx.transition.TransitionManager
import com.wzc.constraintlayoutexamples.databinding.ActivityObjectAnimatorBinding

class ObjectAnimatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityObjectAnimatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjectAnimatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // 点击图片从屏幕左边移动到屏幕右边
        binding.iv1.setOnClickListener { view ->
            val distance = binding.fl.width - view.width
            view.animate()
                .translationX(distance.toFloat())
                .start()
        }
        // 点击图片从屏幕左边移动到屏幕右边，但是没有动画效果
        binding.iv2.setOnClickListener { view ->
            (view.layoutParams as FrameLayout.LayoutParams).gravity = Gravity.CENTER_VERTICAL or Gravity.END
            view.requestLayout()
        }
        // 点击图片从屏幕左边移动到屏幕右边，而且有动画效果
        binding.iv3.setOnClickListener { view ->
            // API 1 引入的 View 动画
            // API 11 引入的属性动画
            // API 18 引入的 Transition 动画
            // 使用过渡框架
            TransitionManager.beginDelayedTransition(binding.fl)
            with(view.layoutParams as FrameLayout.LayoutParams) {
                gravity = Gravity.BOTTOM or Gravity.END
                width *= 2
                height *= 2
            }
            view.requestLayout()
        }
    }
}