package com.wzc.constraintlayoutexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wzc.constraintlayoutexamples.databinding.ActivityBiasConstraintBinding

class BiasConstraintActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBiasConstraintBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiasConstraintBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iv.setOnClickListener {
            binding.tv.append("今天天气怎么样？")
        }
    }
}
