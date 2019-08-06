package com.wzc.constraintlayoutexamples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_parent_position.setOnClickListener{startActivity(Intent(this@MainActivity, ParentPositionActivity::class.java))}
        button_order_position.setOnClickListener{startActivity(Intent(this@MainActivity, OrderPositionActivity::class.java))}
        button_alignment.setOnClickListener{startActivity(Intent(this@MainActivity, AlignmentActivity::class.java))}
        button_base_alignment.setOnClickListener{startActivity(Intent(this@MainActivity, BaseAlignmentActivity::class.java))}
        button_guideline.setOnClickListener{startActivity(Intent(this@MainActivity, GuidelineActivity::class.java))}
        button_barrier.setOnClickListener{startActivity(Intent(this@MainActivity, BarrierActivity::class.java))}
        button_bias_constraint.setOnClickListener{startActivity(Intent(this@MainActivity, BiasConstraintActivity::class.java))}
        button_adjust_view_size.setOnClickListener{startActivity(Intent(this@MainActivity, AdjustViewSizeActivity::class.java))}
        button_matchconstraint_vs_matchparent_1.setOnClickListener{startActivity(Intent(this@MainActivity, MatchContraintVsMatchParentActivity1::class.java))}
        button_matchconstraint_vs_matchparent_2.setOnClickListener{startActivity(Intent(this@MainActivity, MatchContraintVsMatchParentActivity2::class.java))}
        button_chain.setOnClickListener{startActivity(Intent(this@MainActivity, ChainActivity::class.java))}
        button_keyframe_animations.setOnClickListener{startActivity(Intent(this@MainActivity, KeyframeAnimationsActivity::class.java))}
        button_circlular_positioning.setOnClickListener{startActivity(Intent(this@MainActivity, CircularPositioningActivity::class.java))}
    }


}
