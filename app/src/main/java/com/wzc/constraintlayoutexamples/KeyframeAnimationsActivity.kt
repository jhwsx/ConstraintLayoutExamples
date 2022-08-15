package com.wzc.constraintlayoutexamples

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import com.wzc.constraintlayoutexamples.databinding.ActivityKeyframeAnimations1Binding

class KeyframeAnimationsActivity : AppCompatActivity() {
    private var isTwo = false
    private lateinit var binding: ActivityKeyframeAnimations1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeyframeAnimations1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.constraint.setOnClickListener {
            if (isTwo) {
                animateToKeyframeOne()
            } else {
                animateToKeyframeTwo()
            }
            isTwo = !isTwo
        }
    }

    private fun animateToKeyframeTwo() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_keyframe_animations_2)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(
            binding.constraint,
            transition
        ) // constraint 这个 id 是设置在 keyframe_1 上面的
        constraintSet.applyTo(binding.constraint)
    }

    private fun animateToKeyframeOne() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_keyframe_animations_1)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(binding.constraint, transition)
        constraintSet.applyTo(binding.constraint)
    }
}
