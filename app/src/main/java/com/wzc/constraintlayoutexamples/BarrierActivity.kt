package com.wzc.constraintlayoutexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.wzc.constraintlayoutexamples.databinding.ActivityBarrierBinding

class BarrierActivity : AppCompatActivity() {
    private var changed: Boolean = false
    private lateinit var binding: ActivityBarrierBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarrierBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonChange.setOnClickListener {

            val buttonALp = binding.buttonA.layoutParams as ConstraintLayout.LayoutParams
            val buttonBLp = binding.buttonB.layoutParams as ConstraintLayout.LayoutParams
            if (changed) {
                buttonALp.width = 100.dp2px().toInt()
                buttonBLp.width = 50.dp2px().toInt()
            } else {
                buttonALp.width = 50.dp2px().toInt()
                buttonBLp.width = 150.dp2px().toInt()
            }
            changed = !changed
            binding.buttonA.layoutParams = buttonALp
            binding.buttonB.layoutParams = buttonBLp
        }
    }
}
