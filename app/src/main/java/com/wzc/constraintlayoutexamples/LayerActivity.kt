package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wzc.constraintlayoutexamples.databinding.ActivityGroupBinding
import com.wzc.constraintlayoutexamples.databinding.ActivityLayerBinding

class LayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            binding.layer1.apply {
                rotation = 45f
                translationY = 200f
            }
        }

        binding.btn2.setOnClickListener {
            binding.layer2.apply {
                rotation = 45f
                translationY = 200f
            }
        }
    }
}