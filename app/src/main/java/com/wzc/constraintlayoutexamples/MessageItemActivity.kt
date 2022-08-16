package com.wzc.constraintlayoutexamples

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wzc.constraintlayoutexamples.databinding.ActivityMessageItemBinding

/**
 *
 * @author wangzhichao
 * @since 2022/8/16
 */
class MessageItemActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMessageItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}