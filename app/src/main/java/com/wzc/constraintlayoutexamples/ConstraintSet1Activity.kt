package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.wzc.constraintlayoutexamples.databinding.ActivityConstraintSet1Binding

class ConstraintSet1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintSet1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintSet1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener { view ->
            val constraintLayout = view.parent as ConstraintLayout
            val constraintSet = ConstraintSet().apply {
                clone(constraintLayout)
//                clear(R.id.btn)
                // 在两个控件之间建立约束
                connect(R.id.btn, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
                connect(R.id.btn,
                    ConstraintSet.BOTTOM,
                    ConstraintSet.PARENT_ID,
                    ConstraintSet.BOTTOM)
            }
            constraintSet.applyTo(constraintLayout)
        }
    }
}