package com.wzc.constraintlayoutexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_barrier.*

class BarrierActivity : AppCompatActivity() {
    private var changed: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barrier)
        button_change.setOnClickListener {

            val buttonALp = button_a.layoutParams as ConstraintLayout.LayoutParams
            val buttonBLp = button_b.layoutParams as ConstraintLayout.LayoutParams
            if (changed) {
                buttonALp.width = 100.dp2px().toInt()
                buttonBLp.width = 50.dp2px().toInt()
            } else {
                buttonALp.width = 50.dp2px().toInt()
                buttonBLp.width = 150.dp2px().toInt()
            }
            changed = !changed
            button_a.layoutParams = buttonALp
            button_b.layoutParams = buttonBLp
        }
    }
}
