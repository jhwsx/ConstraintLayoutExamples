package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wzc.constraintlayoutexamples.databinding.ActivityPlaceholderBinding

class PlaceholderActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPlaceholderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceholderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.iv1.setOnClickListener(this@PlaceholderActivity)
        binding.iv2.setOnClickListener(this@PlaceholderActivity)
        binding.iv3.setOnClickListener(this@PlaceholderActivity)
    }

    override fun onClick(v: View) {
        binding.placeholder.setContentId(v.id)
    }
}