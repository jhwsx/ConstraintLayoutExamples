package com.wzc.constraintlayoutexamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class TransitionManagerGoActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_manager_go)
        setupData()
    }

    private fun setupData() {
        findViewById<ImageView>(R.id.image_film_cover).setOnClickListener(this)
        findViewById<RatingBar>(R.id.rating_film_rating).rating = 4.5f
        findViewById<TextView>(R.id.text_film_title).text = getString(R.string.film_title)
        findViewById<TextView>(R.id.text_film_description).text =
            getString(R.string.film_description)
    }

    private var toggle = true
    override fun onClick(v: View) {
        // 通过 xml 来决定开始场景，结束场景。
        val root = findViewById<ViewGroup>(R.id.root)
        val startScene = Scene.getSceneForLayout(root, R.layout.go_start, this)
        val endScene = Scene.getSceneForLayout(root, R.layout.go_end, this)
        if (toggle) {
            TransitionManager.go(endScene)
        } else {
            TransitionManager.go(startScene)
        }
        // 切换后，旧布局被移除，添加了新布局，必须要再次设置数据
        setupData()
        toggle = !toggle
    }
}