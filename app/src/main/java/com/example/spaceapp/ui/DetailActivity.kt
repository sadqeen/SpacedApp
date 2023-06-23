package com.example.spaceapp.ui

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.spaceapp.R
import com.example.spaceapp.base.BaseActivity
import com.example.spaceapp.databinding.ActivityDetailBinding


class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    private lateinit var activityDetailBinding: ActivityDetailBinding
    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = getViewBinding()
        var pos=intent.getIntExtra("Pos",0)
        when(pos)
        {
            0->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image1))
            1->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image2))
            2->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image3))
            3->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image4))
            4->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image5))
            5->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image6))
            6->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image7))
            7->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image8))
            8->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image9))
            9->activityDetailBinding.imagebg.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.image10))
        }
        ScheduleTripFragment.dismissEvent.observe(this, Observer {
            if (it) {
                finish();
                overridePendingTransition(
                    R.anim.nothing,
                    R.anim.bottom_down
                )
            }
        })

        activityDetailBinding.backBtn.setOnClickListener {
            finish()
            overridePendingTransition(
                R.anim.nothing,
                R.anim.bottom_down
            )
        }

        activityDetailBinding.btnSchedule.setOnClickListener {
            val scheduleTripFragment = ScheduleTripFragment()
            scheduleTripFragment.show(supportFragmentManager, "ScheduleTrip")
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(
           R.anim.nothing,
            R.anim.bottom_down
        )
    }
}