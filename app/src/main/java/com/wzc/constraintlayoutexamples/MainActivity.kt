package com.wzc.constraintlayoutexamples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wzc.constraintlayoutexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonParentPosition.setOnClickListener{startActivity(Intent(this@MainActivity, ParentPositionActivity::class.java))}
        binding.buttonOrderPosition.setOnClickListener{startActivity(Intent(this@MainActivity, OrderPositionActivity::class.java))}
        binding.buttonAlignment.setOnClickListener{startActivity(Intent(this@MainActivity, AlignmentActivity::class.java))}
        binding.buttonBaseAlignment.setOnClickListener{startActivity(Intent(this@MainActivity, BaseAlignmentActivity::class.java))}
        binding.buttonGuideline.setOnClickListener{startActivity(Intent(this@MainActivity, GuidelineActivity::class.java))}
        binding.buttonBarrier.setOnClickListener{startActivity(Intent(this@MainActivity, BarrierActivity::class.java))}
        binding.buttonBiasConstraint.setOnClickListener{startActivity(Intent(this@MainActivity, BiasConstraintActivity::class.java))}
        binding.buttonAdjustViewSize.setOnClickListener{startActivity(Intent(this@MainActivity, AdjustViewSizeActivity::class.java))}
        binding.buttonMatchconstraintVsMatchparent1.setOnClickListener{startActivity(Intent(this@MainActivity, MatchContraintVsMatchParentActivity1::class.java))}
        binding.buttonMatchconstraintVsMatchparent2.setOnClickListener{startActivity(Intent(this@MainActivity, MatchContraintVsMatchParentActivity2::class.java))}
        binding.buttonChain.setOnClickListener{startActivity(Intent(this@MainActivity, ChainActivity::class.java))}
        binding.buttonKeyframeAnimations.setOnClickListener{startActivity(Intent(this@MainActivity, KeyframeAnimationsActivity::class.java))}
        binding.buttonCirclularPositioning.setOnClickListener{startActivity(Intent(this@MainActivity, CircularPositioningActivity::class.java))}
    }


}
