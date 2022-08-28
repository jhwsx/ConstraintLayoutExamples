package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager

class TransitionManagerConstraintSetActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_manager_constraint_set_start)
        setupData()
    }

    private fun setupData() {
        findViewById<ImageView>(R.id.image_film_cover).setOnClickListener(this)
        findViewById<RatingBar>(R.id.rating_film_rating).rating = 4.5f
        findViewById<TextView>(R.id.text_film_title).text = getString(R.string.film_title)
        findViewById<TextView>(R.id.text_film_description).text =
            getString(R.string.film_description)
    }
    private var toggle = false
    override fun onClick(v: View) {
        // 缺点：
        // 不能停留在任意地方
        // 不支持触摸反馈
        // 布局有重复的地方，在 layout 下面要维护两个有大量重复的布局
        val root = findViewById<ConstraintLayout>(R.id.root)
        TransitionManager.beginDelayedTransition(root)
        ConstraintSet().apply {
            clone(this@TransitionManagerConstraintSetActivity,
                if (toggle) R.layout.activity_transition_manager_constraint_set_start
                else R.layout.activity_transition_manager_constraint_set_end)
            applyTo(root)
        }
        toggle = !toggle
    }
}