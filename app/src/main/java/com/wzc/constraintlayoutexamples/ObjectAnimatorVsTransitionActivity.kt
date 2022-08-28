package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.transition.TransitionManager
import com.wzc.constraintlayoutexamples.databinding.ActivityObjectAnimatorVsTransitionBinding

class ObjectAnimatorVsTransitionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityObjectAnimatorVsTransitionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjectAnimatorVsTransitionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iv1.setOnClickListener(this)
        binding.iv2.setOnClickListener(this)
        binding.iv3.setOnClickListener(this)
        binding.iv4.setOnClickListener(this)
        binding.iv5.setOnClickListener(this)
        binding.iv6.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.iv1, R.id.iv2,R.id.iv3 -> {
                // 属性动画不会影响其他控件的布局参数
                v.animate().scaleX(2f).scaleY(2f).start()
            }
            R.id.iv4, R.id.iv5, R.id.iv6 -> {
                // 需要代码来修改布局参数
                TransitionManager.beginDelayedTransition(binding.ll2)
                with(v.layoutParams as LinearLayout.LayoutParams) {
                    width *= 2
                    height *= 2
                }
                v.requestLayout()
            }
        }
    }
}