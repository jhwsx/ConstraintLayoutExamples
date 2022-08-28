package com.wzc.constraintlayoutexamples

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.*
import com.wzc.constraintlayoutexamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerview.addItemDecoration(DividerItemDecoration(this, VERTICAL))
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        val myAdapter = MyAdapter {
            startActivity(Intent(this@MainActivity, it.clazz))
        }
        binding.recyclerview.adapter = myAdapter
        myAdapter.submitList(listOf(
            Item(R.string.parent_position_activity, ParentPositionActivity::class.java),
            Item(R.string.order_position_activity, OrderPositionActivity::class.java),
            Item(R.string.alignment_activity, AlignmentActivity::class.java),
            Item(R.string.message_item_activity, MessageItemActivity::class.java),
            Item(R.string.weight_activity, WeightActivity::class.java),
            Item(R.string.baseline_alignment_activity, BaselineAlignmentActivity::class.java),
            Item(R.string.bias_constraint_activity, BiasConstraintActivity::class.java),
            Item(R.string.adjust_view_size_activity, AdjustViewSizeActivity::class.java),
            Item(R.string.matchconstraint_vs_matchparent_activity_1,
                MatchConstraintVsMatchParentActivity1::class.java),
            Item(R.string.matchconstraint_vs_matchparent_activity_2,
                MatchConstraintVsMatchParentActivity2::class.java),
            Item(R.string.chain_activity, ChainActivity::class.java),
            Item(R.string.circlular_positioning_activity, CircularPositioningActivity::class.java),
            Item(R.string.constrained_width_height_activity,
                ConstrainedWidthHeightActivity::class.java),
            Item(R.string.gone_margin_activity, GoneMarginActivity::class.java),
            Item(R.string.percent_activity, PercentActivity::class.java),
            Item(R.string.guideline_activity, GuidelineActivity::class.java),
            Item(R.string.group_activity, GroupActivity::class.java),
            Item(R.string.layer_activity, LayerActivity::class.java),
            Item(R.string.barrier_activity, BarrierActivity::class.java),
            Item(R.string.circular_reveal_activity, CircularRevealActivity::class.java),
            Item(R.string.placeholder_activity, PlaceholderActivity::class.java),
            Item(R.string.constraint_set_1_activity, ConstraintSet1Activity::class.java),
            Item(R.string.constraint_set_2_activity, ConstraintSet2Activity::class.java),
            Item(R.string.keyframe_animations_activity, KeyframeAnimationsActivity::class.java),
            Item(R.string.linear_constraint_activity, LinearConstraintActivity::class.java),
            Item(R.string.flow_activity, FlowActivity::class.java),
            Item(R.string.object_animator_activity, ObjectAnimatorActivity::class.java),
            Item(R.string.activity_object_animator_vs_transition, ObjectAnimatorVsTransitionActivity::class.java),
            Item(R.string.activity_transition_manager_go, TransitionManagerGoActivity::class.java),
            Item(R.string.activity_transition_manager_constraint_set, TransitionManagerConstraintSetActivity::class.java),
            Item(R.string.activity_motion_layout, MotionLayoutActivity::class.java),
            Item(R.string.activity_motion_layout_2, MotionLayout2Activity::class.java),
            Item(R.string.activity_motion_layout_3, MotionLayout3Activity::class.java),
            Item(R.string.activity_motion_layout_feature_1, MotionLayoutFeature1Activity::class.java),
            Item(R.string.activity_motion_layout_feature_2, MotionLayoutFeature2Activity::class.java),
            Item(R.string.activity_motion_layout_feature_3, MotionLayoutFeature3Activity::class.java),
        ))
    }

    class MyAdapter(private val itemCallback: (Item) -> Unit) :
        ListAdapter<Item, MyAdapter.MyHolder>(diffCallback) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
            return MyHolder.newInstance(parent, itemCallback)
        }

        override fun onBindViewHolder(holder: MyHolder, position: Int) {
            holder.bindItem(getItem(position))
        }

        class MyHolder(itemView: View, private val itemCallback: (Item) -> Unit) :
            ViewHolder(itemView) {

            private val tv: TextView

            init {
                tv = itemView.findViewById(android.R.id.text1)
            }

            fun bindItem(item: Item) {
                tv.setText(item.strRes)
                tv.setOnClickListener {
                    itemCallback.invoke(item)
                }
            }

            companion object {
                fun newInstance(parent: ViewGroup, itemCallback: (Item) -> Unit): MyHolder {
                    val view = LayoutInflater.from(parent.context)
                        .inflate(android.R.layout.simple_list_item_1, parent, false)
                    return MyHolder(view, itemCallback)
                }
            }
        }

        companion object {
            private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
                override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                    return oldItem == newItem
                }
            }
        }
    }
}

data class Item(val strRes: Int, val clazz: Class<*>)
