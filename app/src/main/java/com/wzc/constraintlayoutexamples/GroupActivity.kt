package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wzc.constraintlayoutexamples.databinding.ActivityGroupBinding

class GroupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGroupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            if (binding.group1.visibility == View.GONE) {
                binding.group1.visibility = View.VISIBLE
            } else {
                binding.group1.visibility = View.GONE
            }
        }
        binding.btn2.setOnClickListener {
            if (binding.group2.visibility == View.GONE) {
                binding.group2.visibility = View.VISIBLE
            } else {
                binding.group2.visibility = View.GONE
            }
        }
    }
}