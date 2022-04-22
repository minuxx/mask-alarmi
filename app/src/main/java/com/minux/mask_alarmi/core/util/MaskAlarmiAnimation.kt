package com.minux.mask_alarmi.core.util

import android.animation.AnimatorSet
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.LinearLayout
import com.minux.mask_alarmi.core.util.Constants.TAG_APP

object MaskAlarmiAnimation {
    fun expandHorizontally(v: View)  {
        // 부모의 width 크기로 지정
        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(
            (v.parent as View).width,
            View.MeasureSpec.EXACTLY
        )

        // 0으로 지정해 content에 맞춰지게끔 설정
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(
            0,
            View.MeasureSpec.UNSPECIFIED
        )

        // measure() 가 인자의 스펙에 맟춰 호출되면 view를 다시 그린다.
        // width가 0일 경우 content에 의해 크기가 맞춰지는 듯하다.
        v.measure(widthMeasureSpec, heightMeasureSpec)
        val targetWidth = v.measuredWidth // 새로 그릴 때 Width Spec에 부모크기를 측정했다.

        val anim = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                v.layoutParams.width = when (interpolatedTime) {
                    0f -> 1 // width가 0임을 방지
                    else -> (targetWidth * interpolatedTime).toInt()
                }
                v.requestLayout()
                Log.d(TAG_APP, "interpolatedTime: $interpolatedTime, width: ${v.layoutParams.width}")
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        anim.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {
                v.visibility = View.VISIBLE
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationRepeat(animation: Animation?) {

            }
        })

        anim.duration = (targetWidth / v.context.resources.displayMetrics.density).toLong()
        v.startAnimation(anim)
    }

    fun collapseHorizontally(v: View) {
        val initialWidth = v.measuredWidth

        val anim = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                if(interpolatedTime == 1f) {
                    v.visibility = View.GONE
                } else {
                    v.layoutParams.width = initialWidth - (initialWidth * interpolatedTime).toInt();
                    v.requestLayout();
                }
            }

            override fun willChangeBounds(): Boolean {
                return true
            }
        }

        anim.duration = (initialWidth / v.context.resources.displayMetrics.density).toLong()
        v.startAnimation(anim)
    }
}