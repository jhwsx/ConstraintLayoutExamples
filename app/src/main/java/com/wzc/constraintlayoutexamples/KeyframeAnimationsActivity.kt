package com.wzc.constraintlayoutexamples

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.ChangeBounds
import androidx.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_keyframe_animations_1.*

class KeyframeAnimationsActivity : AppCompatActivity() {
    private var isTwo = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keyframe_animations_1)
        constraint.setOnClickListener {
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
            constraint,
            transition
        ) // constraint 这个 id 是设置在 keyframe_1 上面的
        constraintSet.applyTo(constraint)
    }

    private fun animateToKeyframeOne() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_keyframe_animations_1)
        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}
