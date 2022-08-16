package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wzc.constraintlayoutexamples.databinding.ActivityGoneMarginBinding

class GoneMarginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoneMarginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoneMarginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            if (binding.avatar.visibility == View.VISIBLE) {
                binding.avatar.visibility = View.GONE
            } else {
                binding.avatar.visibility = View.VISIBLE
            }
        }
    }
}