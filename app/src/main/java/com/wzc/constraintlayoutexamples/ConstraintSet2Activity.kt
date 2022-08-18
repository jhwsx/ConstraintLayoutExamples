package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet
import com.wzc.constraintlayoutexamples.databinding.ActivityConstraintSet2StartBinding

class ConstraintSet2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityConstraintSet2StartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintSet2StartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var flag = true
        binding.constraintLayout.setOnClickListener {
            ConstraintSet().apply {
                isForceId = false
                flag = !flag
                clone(this@ConstraintSet2Activity,
                    if (flag) R.layout.activity_constraint_set_2_start else R.layout.activity_constraint_set_2_end)
                applyTo(binding.constraintLayout)
            }
        }
    }
}